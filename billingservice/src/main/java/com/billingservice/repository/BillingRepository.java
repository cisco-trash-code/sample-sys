package com.billingservice.repository;

import com.billingservice.model.Bill;

import java.util.Optional;

public interface BillingRepository {
    Optional<Bill> getBill(String nic);
}
