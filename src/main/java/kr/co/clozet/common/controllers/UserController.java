package kr.co.clozet.common.controllers;

import kr.co.clozet.common.domains.User;
import kr.co.clozet.common.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return service.login(user);
    }
    @GetMapping("/logout")
    public String logout(){
        return "";
    }
    @GetMapping("/findAll")
    public List<User> findAll() {
        return service.findAll();
    }
    @GetMapping("/findAll/sort")
    public List<User> findAll(Sort sort) {
        return service.findAll(sort);
    }
    @GetMapping("/findAll/pageable")
    public Page<User> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
    @GetMapping("/count")
    public long count() {
        return service.count();
    }
    @PutMapping("/put")
    public String put(@RequestBody User user){
        return "";
    }
    @DeleteMapping("/delete")
    public String delete(User user) {
        return service.delete(user);

    }
    @PostMapping("/join")
    public String save(@RequestBody User user) {
        return service.save(user);

    }
    @GetMapping("/findById/{userId}")
    public Optional<User> findById(@PathVariable String userId) {
        return service.findById(userId);
    }
    @GetMapping("/existsById/{userId}")
    public boolean existsById(@PathVariable String userId) {
        return service.existsById(userId);
    }
}
