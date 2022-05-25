package kr.co.clozet.user.services;

import kr.co.clozet.auth.domains.Messenger;
import kr.co.clozet.user.domains.User;
import kr.co.clozet.user.domains.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
// 로그인
public interface UserService {
    UserDto login(User user);

    Messenger put(User user);

    List<User> findAll();

    List<User> findAll(Sort sort);

    Page<User> findAll(Pageable pageable);

    Messenger count();

    Messenger delete(User user);

    Messenger save(User user);

    Optional<User> findById(@PathVariable String userid);

    Messenger existsById(String userid);

    List<User> findByUserName(String name);

    Messenger logout(User user);
}
