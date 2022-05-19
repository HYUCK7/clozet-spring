package kr.co.clozet.soccer.repositories;

import kr.co.clozet.auth.domains.User;
import kr.co.clozet.soccer.domains.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface StadiumCustomRepository{

}

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long>, StadiumCustomRepository {
}
