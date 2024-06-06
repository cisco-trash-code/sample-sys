package com.billingservice.service.impl;

import com.billingservice.model.Bill;
import com.billingservice.repository.BillingRepository;
import com.billingservice.service.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillingServiceImpl implements BillingService {

    private final BillingRepository billingRepository;

    @Override
    public Optional<Bill> getBill(String nic) {
        Optional<Bill> bill = billingRepository.getBill(nic);
        if (bill.isPresent() && bill.get().getAmount() == null) {
            bill.get().setAmount(BigDecimal.ZERO);
        }
        return bill;
    }
}
