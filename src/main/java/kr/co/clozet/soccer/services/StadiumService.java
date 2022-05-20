package kr.co.clozet.soccer.services;

import kr.co.clozet.soccer.domains.Stadium;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface StadiumService {
    List<Stadium> findAll();
    List<Stadium> findAll(Sort sort);
    List<Stadium> findAll(Pageable pageable);

    long count();

    String delete(Stadium stadium);

    Optional<Stadium> findById(String PlayerId);

    boolean existsById(String PlayerId);
}
