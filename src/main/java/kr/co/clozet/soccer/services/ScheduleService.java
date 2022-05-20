package kr.co.clozet.soccer.services;

import kr.co.clozet.soccer.domains.Schedule;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    List<Schedule> findAll();
    List<Schedule> findAll(Sort sort);
    List<Schedule> findAll(Pageable pageable);

    long count();

    String delete(Schedule schedule);

    Optional<Schedule> findById(String PlayerId);

    boolean existsById(String scheduleid);
}
