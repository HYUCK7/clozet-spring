package kr.co.clozet.soccer.repositories;

import kr.co.clozet.soccer.domains.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

interface ScheduleCustomRepository{
    // 스케줄 날짜만 수정이 되도록 변경

    @Query (value = "update schedule s set s.scheDate = :scheDate where s.scheduleNo = :scheduleNo",
        nativeQuery = true)
    String update(@Param("scheDate") String scheDate);
}

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> , ScheduleCustomRepository{
}
