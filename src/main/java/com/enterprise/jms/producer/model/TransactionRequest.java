package com.enterprise.jms.producer.model;

import java.math.BigDecimal;

public record TransactionRequest(
        String transactionId,
        String accountId,
        BigDecimal amount,
        String currency
) {}
