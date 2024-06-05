package com.billingservice.service.impl;

import com.billingservice.model.Bill;
import com.billingservice.repository.BillingRepository;
import com.billingservice.service.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillingServiceImpl implements BillingService {

    private final BillingRepository billingRepository;

    @Override
    public Optional<Bill> getBill(String nic) {
        return billingRepository.getBill(nic);
    }
}
