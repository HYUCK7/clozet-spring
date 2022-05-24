package kr.co.clozet.user.services;

import kr.co.clozet.user.domains.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
// 로그인
public interface UserService {
    String login(User user);

    String put(User user);

    List<User> findAll();

    List<User> findAll(Sort sort);

    Page<User> findAll(Pageable pageable);

    long count();

    String delete(User user);

    String save(User user);

    Optional<User> findById(@PathVariable String userid);

    boolean existsById(String userid);

    List<User> findByUserName(String name);
}
