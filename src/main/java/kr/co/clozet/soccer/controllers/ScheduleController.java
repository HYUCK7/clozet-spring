package kr.co.clozet.soccer.controllers;

import kr.co.clozet.soccer.domains.Schedule;
import kr.co.clozet.soccer.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService service;

    @GetMapping("/findAll")
    public List<Schedule> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAll/sort")
    public List<Schedule> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Schedule> findAll(Pageable pageable) {
        return (Page<Schedule>) service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Schedule Schedule) {
        return service.delete(Schedule);
    }
    @GetMapping("/findById/{PlayerId}")
    public Optional<Schedule> findById(@PathVariable String PlayerId) {
        return service.findById(PlayerId);
    }

    @GetMapping("/existsById/{PlayerId}")
    public boolean existsById(@PathVariable String PlayerId) {
        return service.existsById(PlayerId);
    }
}
