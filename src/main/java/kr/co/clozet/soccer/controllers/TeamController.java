package kr.co.clozet.soccer.controllers;

import kr.co.clozet.soccer.domains.Player;
import kr.co.clozet.soccer.domains.Team;
import kr.co.clozet.soccer.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService service;

    @GetMapping("/findAll")
    public List<Team> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAll/sort")
    public List<Team> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Team> findAll(Pageable pageable) {
        return (Page<Team>) service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Team Team) {
        return service.delete(Team);
    }
    @GetMapping("/findById/{PlayerId}")
    public Optional<Team> findById(@PathVariable String PlayerId) {
        return service.findById(PlayerId);
    }

    @GetMapping("/existsById/{PlayerId}")
    public boolean existsById(@PathVariable String PlayerId) {
        return service.existsById(PlayerId);
    }
    @PostMapping("/save")
    public String save(Team team){
        return service.save(team);
    }
}
