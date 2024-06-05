package com.userservice.repository;

import com.userservice.model.User;

import java.util.Optional;

public interface UserRepository {
    Integer createUser(User user);
    Optional<User> getUser(String id);
    Integer updateUser(String nic, User user);
    Integer deleteUser(String id);
}
