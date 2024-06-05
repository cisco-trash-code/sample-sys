package com.billingservice.api;

import com.billingservice.model.Bill;
import com.billingservice.service.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bill")
@RequiredArgsConstructor
public class BillingRepository {

    private final BillingService billingService;

    @GetMapping("/{nic}")
    public Optional<Bill> getBill(@PathVariable(value = "nic") String nic) {
        return billingService.getBill(nic);
    }

}
