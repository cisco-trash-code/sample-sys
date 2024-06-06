package com.userservice.service;

import com.userservice.dto.UserDetailDTO;
import com.userservice.model.User;

public interface UserService {
    String createUser(User user);
    User getUser(String id);
    String updateUser(String nic, User user);
    String deleteUser(String id);
    UserDetailDTO getUserDetail(String nic);
}
