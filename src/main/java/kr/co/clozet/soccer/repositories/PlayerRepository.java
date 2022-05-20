package kr.co.clozet.soccer.repositories;

import kr.co.clozet.soccer.domains.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

interface PlayerCustomRepository{
    //선수들의 키와 몸무게를 변경하시오.

    @Query (value = "update player p set p.height = :height, p.weight = :weight where p.playerNo = :playerNo",
        nativeQuery = true)
    int update(@Param("weight") String weight, @Param("height") String height);
}

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>, PlayerCustomRepository {

}
