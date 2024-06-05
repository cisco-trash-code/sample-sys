package com.billingservice.service;

import com.billingservice.model.Bill;

import java.util.Optional;

public interface BillingService {
    Optional<Bill> getBill(String nic);
}
