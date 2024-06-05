package com.userservice.service;

import com.userservice.model.User;

public interface UserService {
    String createUser(User user);
    User getUser(String id);
    String updateUser(String nic, User user);
    String deleteUser(String id);
}
