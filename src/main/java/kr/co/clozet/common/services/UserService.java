package kr.co.clozet.common.services;

import kr.co.clozet.common.domains.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface UserService {
    String login(User user);

    List<User> findAll();
    List<User> findAll(Sort sort);
    Page<User> findAll(Pageable pageable);

    long count();

    String delete(User user);

    String save(User user);

    Optional<User> findById(String userId);

    boolean existsById(String userId);

    Page<User> findAll(org.springframework.data.domain.Pageable pageable);
}
