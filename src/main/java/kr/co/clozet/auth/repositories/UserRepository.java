package kr.co.clozet.auth.repositories;

import kr.co.clozet.auth.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

interface UserCustomRepository{

    void update(User user);
    String Login(User user);
}

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
