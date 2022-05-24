package kr.co.clozet.user.repositories;

import kr.co.clozet.user.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

interface UserCustomRepository{

    void update(User user);
    String Login(User user);
}

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}
