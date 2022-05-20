package kr.co.clozet.soccer.controllers;



import kr.co.clozet.soccer.domains.Player;
import kr.co.clozet.soccer.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService service;

    @GetMapping("/findAll")
    public List<Player> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAll/sort")
    public List<Player> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Player> findAll(Pageable pageable) {
        return (Page<Player>) service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Player player) {
        return service.delete(player);
    }

    @GetMapping("/findById/{PlayerId}")
    public Optional<Player> findById(@PathVariable String PlayerId) {
        return service.findById(PlayerId);
    }

    @GetMapping("/existsById/{PlayerId}")
    public boolean existsById(@PathVariable String PlayerId) {
        return service.existsById(PlayerId);
    }
    @PostMapping("/save")
    public String save(Player player){
        return service.save(player);
    }
}

