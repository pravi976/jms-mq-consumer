package com.enterprise.regression.upstream.ops;

import com.enterprise.regression.upstream.customer.CustomerProfileRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/upstream/ops")
public class UpstreamOpsController {
    private final CustomerProfileRepository repository;

    public UpstreamOpsController(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/status")
    public Map<String, Object> status() {
        return Map.of(
                "service", "regression-test-upstream",
                "status", "UP",
                "customersLoaded", repository.count(),
                "profileSource", "in-memory"
        );
    }
}
