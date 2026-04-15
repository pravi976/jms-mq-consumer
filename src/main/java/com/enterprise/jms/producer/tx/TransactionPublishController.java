package com.enterprise.jms.producer.tx;

import com.enterprise.jms.producer.model.TransactionRequest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/jms/tx")
public class TransactionPublishController {
    private final JmsTemplate jmsTemplate;

    public TransactionPublishController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping("/publish")
    public Map<String, Object> publish(@RequestBody TransactionRequest request) {
        jmsTemplate.convertAndSend("banking.tx.requests", request);
        return Map.of(
                "status", "PUBLISHED",
                "transactionId", request.transactionId(),
                "publishedAt", OffsetDateTime.now().toString()
        );
    }
}
