package com.userservice.service.impl;

import com.userservice.dto.UserDetailDTO;
import com.userservice.model.Billing;
import com.userservice.model.User;
import com.userservice.repository.UserRepository;
import com.userservice.service.UserService;
import com.userservice.util.Constants;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final WebClient webClient;
    private final UserRepository userRepository;
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public String createUser(User user) {
        try {
            log.info("UserServiceImpl=>createUser=>start");
            Integer res = userRepository.createUser(user);
            return res > 0 ? Constants.SUCCESS : Constants.FAIL;
        } catch (Exception ex) {
            log.error("UserServiceImpl=>createUser", ex);
            return Constants.ERROR;
        }

    }

    @Override
    public User getUser(String id) {
        try {
            log.info("UserServiceImpl=>getUser=>start");
            Optional<User> res = userRepository.getUser(id);
            return res.orElse(null);
        } catch (Exception ex) {
            log.error("UserServiceImpl=>getUser", ex);
            return null;
        }
    }

    @Override
    public String updateUser(String nic, User user) {
        try {
            log.info("UserServiceImpl=>updateUser=>start");
            Integer res = userRepository.updateUser(nic, user);
            return res > 0 ? Constants.SUCCESS : Constants.FAIL;
        } catch (Exception ex) {
            log.error("UserServiceImpl=>updateUser", ex);
            return Constants.ERROR;
        }
    }

    @Override
    public String deleteUser(String id) {
        try {
            log.info("UserServiceImpl=>deleteUser=>start");
            Integer res = userRepository.deleteUser(id);
            return res > 0 ? Constants.SUCCESS : Constants.FAIL;
        } catch (Exception ex) {
            log.error("UserServiceImpl=>deleteUser", ex);
            return Constants.ERROR;
        }
    }

    @Override
    public UserDetailDTO getUserDetail(String nic) {
        log.info("UserServiceImpl=>getUserDetail=>start");
        UserDetailDTO userDetail = new UserDetailDTO();
        try {
            Optional<User> user = userRepository.getUser(nic);
            if (user.isPresent()) {
                Billing billInfo = getBillingForUser(nic);
                userDetail.setNic(user.get().getNic());
                userDetail.setUserName(user.get().getUserName());
                userDetail.setAddress(user.get().getAddress());
                if(billInfo != null) {
                    userDetail.setAmount(billInfo.getAmount());
                }
            }
        } catch (Exception ex) {
            log.error("UserServiceImpl=>getUserDetail", ex);
        }
        return userDetail;
    }

    private Billing getBillingForUser(String nic) {
        log.info("UserServiceImpl=>getBillingForUser=>start");
        var baseURL = "http://localhost:8083/api/v1/bill/";
        return webClient.get()
                .uri(baseURL.concat(nic))
                .retrieve()
                .bodyToMono(Billing.class)
                .block();
    }
}


