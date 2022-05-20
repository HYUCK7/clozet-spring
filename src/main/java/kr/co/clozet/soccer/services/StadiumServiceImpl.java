package kr.co.clozet.soccer.services;

import kr.co.clozet.soccer.domains.Stadium;
import kr.co.clozet.soccer.repositories.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StadiumServiceImpl implements StadiumService{
    private final ScheduleRepository repository;

    @Override
    public List<Stadium> findAll() {
        return null;
    }

    @Override
    public List<Stadium> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<Stadium> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public String delete(Stadium stadium) {
        return null;
    }

    @Override
    public Optional<Stadium> findById(String PlayerId) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String PlayerId) {
        return false;
    }
}
