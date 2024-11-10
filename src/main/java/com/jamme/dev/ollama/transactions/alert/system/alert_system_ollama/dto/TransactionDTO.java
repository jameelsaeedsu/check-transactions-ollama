package com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDTO(
        String transactionMessage,
        String accountNumber,
        BigDecimal amount,
        String transactionType,
        String country,
        LocalDateTime transactionDate
) {
}
