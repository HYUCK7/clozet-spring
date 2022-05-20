package kr.co.clozet.soccer.controllers;

import kr.co.clozet.soccer.domains.Stadium;
import kr.co.clozet.soccer.services.StadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stadiums")
@RequiredArgsConstructor
public class StadiumController {
    private final StadiumService service;

    @GetMapping("/findAll")
    public List<Stadium> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAll/sort")
    public List<Stadium> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Stadium> findAll(Pageable pageable) {
        return (Page<Stadium>) service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Stadium Stadium) {
        return service.delete(Stadium);
    }
    @GetMapping("/findById/{PlayerId}")
    public Optional<Stadium> findById(@PathVariable String PlayerId) {
        return service.findById(PlayerId);
    }

    @GetMapping("/existsById/{PlayerId}")
    public boolean existsById(@PathVariable String PlayerId) {
        return service.existsById(PlayerId);
    }
}
