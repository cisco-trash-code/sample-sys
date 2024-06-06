package com.userservice.api;

import com.userservice.dto.ResponseDTO;
import com.userservice.dto.UserDetailDTO;
import com.userservice.model.User;
import com.userservice.service.UserService;
import com.userservice.util.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/{nic}")
    public User getUser(@PathVariable(value = "nic") String nic) {
        log.info("UserController=>getUser=>start");
        User user = userService.getUser(nic);
        if(userService.getUser(nic) != null) {
            ResponseDTO response = new ResponseDTO();
            response.setMessage(Constants.SUCCESS);
            response.setCode("200");
            response.setData(user);
        }
        return userService.getUser(nic);
    }

    @PostMapping
    public String createUser(@Valid @RequestBody User user) {
        log.info("UserController=>createUser=>start");
        return userService.createUser(user);
    }

    @PutMapping("/{nic}")
    public String updateUser(@PathVariable(value = "nic") String nic, @Valid @RequestBody User user) {
        log.info("UserController=>updateUser=>start");
        return userService.updateUser(nic, user);
    }

    @DeleteMapping("/{nic}")
    public String deleteUser(@PathVariable(value = "nic") String nic) {
        log.info("UserController=>deleteUser=>start");
        return userService.deleteUser(nic);
    }

    @GetMapping("/detail/{nic}")
    public UserDetailDTO getUserDetail(@PathVariable(value = "nic") String nic){
        log.info("UserController=>getUserDetail=>start");
        return userService.getUserDetail(nic);
    }

    @GetMapping("/vt")
    public String vt() {
        return Thread.currentThread().getName();
    }

}
