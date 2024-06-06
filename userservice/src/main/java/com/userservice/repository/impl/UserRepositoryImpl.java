package com.userservice.repository.impl;

import com.userservice.model.User;
import com.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcClient jdbcClient;
    private static final Logger log = LoggerFactory.getLogger(UserRepositoryImpl.class);

    public UserRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Integer createUser(User user) {
        log.info("UserRepositoryImpl=>createUser=>start");
        var query = "INSERT INTO users (nic, user_name, address) VALUES (?,?,?)";

        return jdbcClient.sql(query)
                .param(1, user.getNic())
                .param(2, user.getUserName())
                .param(3, user.getAddress())
                .update();
    }

    @Override
    public Optional<User> getUser(String id) {
        log.info("UserRepositoryImpl=>getUser=>start");
        var sql = "SELECT * FROM users WHERE nic=?";

        return jdbcClient.sql(sql)
                .param(id)
                .query(User.class)
                .optional();
    }

    @Override
    public Integer updateUser(String nic, User user) {
        log.info("UserRepositoryImpl=>updateUser=>start");
        var sql = "UPDATE users SET user_name=?, address=? WHERE nic=?";

        return jdbcClient.sql(sql)
                .param(1, user.getUserName())
                .param(2, user.getAddress())
                .param(3, nic)
                .update();
    }

    @Override
    public Integer deleteUser(String id) {
        log.info("UserRepositoryImpl=>deleteUser=>start");
        var sql = "DELETE FROM users WHERE nic=?";

        return jdbcClient.sql(sql)
                .params(id)
                .update();
    }
}
