package kr.co.clozet.soccer.repositories;

import kr.co.clozet.auth.domains.User;
import kr.co.clozet.soccer.domains.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface TeamCustomRepository{
// 코딩 그렇게 하는거 아닌데...
    // 아직도 모르네....
    // 수구요...
}

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>, TeamCustomRepository {
}
