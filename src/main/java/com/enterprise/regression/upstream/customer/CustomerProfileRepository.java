package com.enterprise.regression.upstream.customer;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class CustomerProfileRepository {
    private final Map<String, CustomerProfile> customerProfiles = Map.of(
            "CUST-1001", new CustomerProfile(
                    "CUST-1001",
                    "Asha Verma",
                    "Bengaluru",
                    "GOLD",
                    "ACTIVE",
                    new BigDecimal("12500.75"),
                    "INR"
            ),
            "CUST-1002", new CustomerProfile(
                    "CUST-1002",
                    "Rohan Mehta",
                    "Mumbai",
                    "SILVER",
                    "ACTIVE",
                    new BigDecimal("8400.00"),
                    "INR"
            ),
            "CUST-1003", new CustomerProfile(
                    "CUST-1003",
                    "Neha Iyer",
                    "Bengaluru",
                    "PLATINUM",
                    "ACTIVE",
                    new BigDecimal("22500.50"),
                    "INR"
            )
    );

    public Optional<CustomerProfile> findById(String customerId) {
        return Optional.ofNullable(customerProfiles.get(customerId));
    }

    public List<CustomerProfile> findByCity(String city) {
        return customerProfiles.values().stream()
                .filter(profile -> profile.city().equalsIgnoreCase(city))
                .sorted((left, right) -> left.customerId().compareTo(right.customerId()))
                .toList();
    }

    public int count() {
        return customerProfiles.size();
    }
}
