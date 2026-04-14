package com.enterprise.regression.upstream.customer;

import java.math.BigDecimal;

public record CustomerProfile(
        String customerId,
        String customerName,
        String city,
        String tier,
        String status,
        BigDecimal creditLimit,
        String currency
) {
}
