package kr.co.clozet.soccer.repositories;

import kr.co.clozet.auth.domains.User;
import kr.co.clozet.soccer.domains.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

interface StadiumCustomRepository{
    // 스타디움 전화번호 tel을 변경
    /*
     //000. 팀의 전화번호와 팩스번호를 수정하시오.
    @Query (value = "update team t set t.tel = :tel, t.fax = :fax where t.teamNo = :teamNo",
        nativeQuery = true)
    int update(@Param("tel") String tel, @Param("fax") String fax);
     */
    @Query (value = "update Stadium s set s.tel = :tel where s.stadiumNo :stadiumNo",
        nativeQuery = true)
    String update(@Param("tel") String tel);
}

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long>, StadiumCustomRepository {
}
