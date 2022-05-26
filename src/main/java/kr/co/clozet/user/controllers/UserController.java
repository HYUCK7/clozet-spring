package kr.co.clozet.user.controllers;

import io.swagger.annotations.*;
import kr.co.clozet.auth.domains.Messenger;
import kr.co.clozet.user.domains.User;
import kr.co.clozet.user.domains.UserDto;
import kr.co.clozet.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "users")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final ModelMapper modelMapper;

        // @ApiResponse(code = 400, message = "Something Wrong"),
        // @ApiResponse(code = 422, message = "중복된 ID")
    @PostMapping("/login")
    @ApiOperation(value = "${UserController.Login")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something Wrong"),
            @ApiResponse(code = 422, message = "중복된 ID")
    })
    public ResponseEntity<UserDto> login(@ApiParam("Login User")@RequestBody UserDto user) {
        return ResponseEntity.ok(service.login(user));
    }

    @GetMapping("/logout")
    public ResponseEntity logout() {
        return ResponseEntity.ok(Messenger.builder().build());
    }

    @PutMapping("/put")
    public ResponseEntity<Messenger> put(@RequestBody UserDto user) {
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
    public Messenger delete(@RequestBody UserDto user) {
        return service.delete(user);
    }


    @PostMapping("/join")
    @ApiOperation(value = "${UserController.join")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something Wrong"),
            @ApiResponse(code = 403, message = "승인거절"),
            @ApiResponse(code = 422, message = "중복된 ID")
    })
    public ResponseEntity<Messenger> save(@ApiParam("Join User") @RequestBody UserDto user) {
        System.out.println("회원가입 정보: " + user.toString());
        return ResponseEntity.ok(service.save(user));
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
