package com.userservice.api;

import com.userservice.model.User;
import com.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{nic}")
    public User getUser(@PathVariable(value = "nic") String nic) {
        return userService.getUser(nic);
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{nic}")
    public String updateUser(@PathVariable(value = "nic") String nic, @RequestBody User user) {
        return userService.updateUser(nic, user);
    }

    @DeleteMapping("/{nic}")
    public String deleteUser(@PathVariable(value = "nic") String nic) {
        return userService.deleteUser(nic);
    }

    @GetMapping("/vt")
    public String vt() {
        return Thread.currentThread().getName();
    }

}
