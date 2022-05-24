package kr.co.clozet.soccer.services;

import kr.co.clozet.soccer.domains.Player;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    List<Player> findAll();
    List<Player> findAll(Sort sort);
    List<Player> findAll(Pageable pageable);
    int count();
    String delete(Player player);
    Optional<Player> findById(String PlayerId);
    boolean existsById(String PlayerId);
    String save(Player player);
}
