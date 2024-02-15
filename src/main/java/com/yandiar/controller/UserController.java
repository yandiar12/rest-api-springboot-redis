package com.yandiar.controller;

import com.yandiar.model.User;
import com.yandiar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author YAR
 */

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User create(@RequestBody User dto) {
        System.out.println(dto.toString());
        return userService.createUser(dto);
    }
}
