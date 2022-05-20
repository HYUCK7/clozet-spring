package kr.co.clozet.soccer.services;

import kr.co.clozet.soccer.domains.Team;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    List<Team> findAll();
    List<Team> findAll(Sort sort);
    List<Team> findAll(Pageable pageable);

    long count();

    String delete(Team team);

    boolean existsById(String teamid);

    Optional<Team> findById(String teamid);

    String save(Team team);
}
