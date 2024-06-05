package com.userservice.repository.impl;

import com.userservice.model.User;
import com.userservice.repository.UserRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcClient jdbcClient;

    public UserRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Integer createUser(User user) {
        var query = "INSERT INTO users (nic, user_name, address) VALUES (?,?,?)";

        return jdbcClient.sql(query)
                .param(1, user.getNic())
                .param(2, user.getUserName())
                .param(3, user.getAddress())
                .update();
    }

    @Override
    public Optional<User> getUser(String id) {
        var sql = "SELECT * FROM users WHERE nic=?";

        return jdbcClient.sql(sql)
                .param(id)
                .query(User.class)
                .optional();
    }

    @Override
    public Integer updateUser(String nic, User user) {
        var sql = "UPDATE users SET user_name=?, address=? WHERE nic=?";

        return jdbcClient.sql(sql)
                .param(1, user.getUserName())
                .param(2, user.getAddress())
                .param(3, nic)
                .update();
    }

    @Override
    public Integer deleteUser(String id) {
        var sql = "DELETE FROM users WHERE nic=?";

        return jdbcClient.sql(sql)
                .params(id)
                .update();
    }
}
