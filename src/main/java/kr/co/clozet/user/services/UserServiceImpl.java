package kr.co.clozet.user.services;

import kr.co.clozet.auth.configs.AuthProvider;
import kr.co.clozet.auth.domains.Messenger;
import kr.co.clozet.auth.exception.SecurityRuntimeException;
import kr.co.clozet.user.domains.Role;
import kr.co.clozet.user.domains.User;
import kr.co.clozet.user.domains.UserDto;
import kr.co.clozet.user.repositories.UserRepository;
import kr.co.clozet.common.dataStructure.Box;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static kr.co.clozet.common.lambda.Lambda.longParse;
import static kr.co.clozet.common.lambda.Lambda.string;
import static kr.co.clozet.common.lambda.Lambda.date;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    private final PasswordEncoder encoder;// 반드시 필요함. 패스워드 암호화
    private final AuthProvider provider;
    private final ModelMapper modelMapper; // 엔티티와 DTO를 Change

    @Override
    public UserDto login(UserDto paramUser) {
        try{
            // 변수 밖에 없기 때문에, Class에 담는다.
            UserDto returnUser = new UserDto();
            String username = paramUser.getUsername();
            User findUser = repository.findByUsername(username).orElse(null);
            if(findUser != null) {
                boolean checkPassword = encoder.matches(paramUser.getPassword(), findUser.getPassword());
                if (checkPassword) {
                    returnUser = modelMapper.map(findUser, UserDto.class);  // user Repository와 UserDTO에 대한 매핑
                    String token =  provider.createToken(username, returnUser.getRoles());
                    returnUser.setToken(token);
                } else {
                    String token = "FAILURE";
                    returnUser.setToken(token);
                }
            }
            return returnUser;
            // 1vs1로 같은 속성 끼리 치환을 함. (누락된 건 없어야 함) map, reduce, filter
        } catch (Exception e){
            throw new SecurityRuntimeException("유효하지 않은 ID/PW", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public Messenger put(UserDto user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Messenger count() {
        return Messenger.builder().message(string(repository.count())).build();
    }

    @Override
    public Messenger delete(UserDto user) {
        return Messenger.builder().message("").build();

    }

    @Override
    public Messenger save(UserDto user) {
        System.out.println("서비스로 전달된 회원가입 정보 : +" + user.toString());
        // optional<User> findByUsername(String username) 레퍼지토리 메소드 -> 이 중 null이면 사용가능.
        // optional value 가져오기 -> get orElse olElseGet
        String result = "";
        //boolean existUsernameCheck = o == null ? true : false;
        if(repository.findByUsername(user.getUsername()).isEmpty()) {
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            repository.save(User.builder()
                    .username(user.getUsername())
                    .name(user.getName())
                    .regDate(user.getRegDate())
                    .email(user.getEmail())
                    .password(encoder.encode(user.getPassword()))
                    .roles(list)
                    .build());
            result = "SUCCESS";
        }else{
            result = "FAIL";
        }
        return Messenger.builder().message(result).build();
    }

    @Override
    public Optional<User> findById(String userid) {
        return Optional.empty();
    }

    @Override
    public Messenger existsById(String userid) {
        return repository.existsById(longParse(userid))
                ?Messenger.builder().message("EXIST").build()
                :Messenger.builder().message("NOT_EXIST").build();
    }

    @Override
    public List<User> findByUserName(String name){
        List<User> ls = repository.findAll();
        Box<String, User> box = new Box<>();
        //box.findByUserName(ls, name);
        //ls.stream().filter(...)
        return null;
    }

    @Override
    public Messenger logout(UserDto user) {
        return null;
    }
}
