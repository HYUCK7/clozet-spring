package kr.co.clozet.user.controllers;

import kr.co.clozet.auth.domains.Messenger;
import kr.co.clozet.user.domains.User;
import kr.co.clozet.user.domains.UserDto;
import kr.co.clozet.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody User user) {
        return ResponseEntity.ok(service.login(user));
    }

    @GetMapping("/logout")
    public ResponseEntity logout() {
        return ResponseEntity.ok(Messenger.builder().build());
    }

    @PutMapping("/put")
    public ResponseEntity<Messenger> put(@RequestBody User user) {
        return ResponseEntity.ok(service.put(user));
    }

    // Embeded Methods
    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/findAll/sort")
    public  ResponseEntity<List<User>> findAll(Sort sort) {
        return ResponseEntity.ok(service.findAll(sort));
    }

    @GetMapping("/findAll/pageable")
    public ResponseEntity<Page<User>> findAll(Pageable pageable) {
        return  ResponseEntity.ok (service.findAll(pageable));
    }

    @GetMapping("/count")
    public Messenger count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public Messenger delete(@RequestBody User user) {
        return service.delete(user);
    }

    @PostMapping("/join")
    public Messenger save(@RequestBody User user) {
        return service.save(user);
    }

    @GetMapping("/findById/{userid}")
    public Optional<User> findById(@PathVariable String userid) {
        return service.findById(userid);
    }

    @GetMapping("/existsById/{userid}")
    public Messenger existsById(@PathVariable String userid) {
        return service.existsById(userid);
    }
}
