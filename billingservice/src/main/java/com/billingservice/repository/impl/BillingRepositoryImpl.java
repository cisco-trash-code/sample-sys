package com.billingservice.repository.impl;

import com.billingservice.model.Bill;
import com.billingservice.repository.BillingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BillingRepositoryImpl implements BillingRepository {

    private final JdbcClient jdbcClient;

    @Override
    public Optional<Bill> getBill(String nic) {
        var sql = "SELECT * FROM bill WHERE nic =?";
        return jdbcClient.sql(sql)
                .param(1, nic)
                .query(Bill.class)
                .optional();
    }
}
