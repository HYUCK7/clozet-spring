package kr.co.clozet.auth.services;

import kr.co.clozet.auth.domains.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
}