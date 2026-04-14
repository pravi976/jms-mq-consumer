package com.enterprise.regression.upstream.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/upstream/customers")
public class CustomerProfileController {
    private final CustomerProfileRepository repository;

    public CustomerProfileController(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerProfile> getCustomer(@PathVariable String customerId) {
        return repository.findById(customerId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public Map<String, Object> searchByCity(@RequestParam String city) {
        List<CustomerProfile> customers = repository.findByCity(city);
        return Map.of(
                "city", city,
                "count", customers.size(),
                "customers", customers
        );
    }
}
