package kr.co.clozet.user.services;

import kr.co.clozet.user.domains.User;
import kr.co.clozet.user.repositories.UserRepository;
import kr.co.clozet.common.dataStructure.Box;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    @Override
    public String login(User user) {
        return null;
    }

    @Override
    public String put(User user) {
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
    public long count() {
        return 0;
    }

    @Override
    public String delete(User user) {
        return null;
    }

    @Override
    public String save(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(String userid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String userid) {
        return false;
    }

    @Override
    public List<User> findByUserName(String name){
        List<User> ls = repository.findAll();
        Box<String, User> box = new Box<>();
        //box.findByUserName(ls, name);
        //ls.stream().filter(...)
        return null;
    }
}
