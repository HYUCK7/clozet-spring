package kr.co.clozet.soccer.repositories;

import kr.co.clozet.soccer.domains.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface ScheduleCustomRepository{

}

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> , ScheduleCustomRepository{
}
