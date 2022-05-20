package kr.co.clozet.soccer.services;

import kr.co.clozet.auth.domains.User;
import kr.co.clozet.soccer.domains.Player;
import kr.co.clozet.soccer.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService{
    private final PlayerRepository repository;

    @Override
    public List<Player> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Player> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<Player> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public String delete(Player player) {
        return null;
    }

    @Override
    public Optional<Player> findById(String userid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String userid) {
        return false;
    }

    @Override
    public String save(Player player) {
        return null;
    }
}
