package com.userservice.service.impl;

import com.userservice.model.User;
import com.userservice.repository.UserRepository;
import com.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String createUser(User user) {
        Integer res = userRepository.createUser(user);
        return res > 0 ? "USER CREATED" : "FAILED";

    }

    @Override
    public User getUser(String id) {
        Optional<User> res = userRepository.getUser(id);
        return res.orElse(null);
    }

    @Override
    public String updateUser(String nic, User user) {
        Integer res = userRepository.updateUser(nic, user);
        return res > 0 ? "USER UPDATED" : "FAILED";
    }

    @Override
    public String deleteUser(String id) {
        Integer res = userRepository.deleteUser(id);
        return res > 0 ? "USER DELETED" : "FAILED";
    }
}
