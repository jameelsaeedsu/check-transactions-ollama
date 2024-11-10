package com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.service.impl;

import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.constants.Status;
import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.constants.TransactionType;
import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.dto.TransactionDTO;
import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.model.Transaction;
import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.service.TransactionService;
import dev.langchain4j.service.UserName;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final RestTemplate restTemplate;

    public TransactionServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Transaction check(TransactionDTO transactionDTO) {

        return new Transaction(
                transactionDTO.transactionMessage(),
                transactionDTO.accountNumber(),
                transactionDTO.amount(),
                TransactionType.INTERNAL_TRANSFER,
                Status.PENDING,
                true,
                "HIGH AMOUNT",
                "SWITZERLAND",
                transactionDTO.transactionDate()
        );
    }

    @Override
    public String register(Transaction checkedTransaction) {
        String url = "http://localhost:8081/api/v1/transactions/register";

        ResponseEntity<String> response = restTemplate.postForEntity(url, checkedTransaction, String.class);

        return response.getBody();
    }

    @Override
    public String getTransaction(@UserName String id) {
        TransactionDTO transactionDTO = new TransactionDTO(
                "Groceries",
                "5423210901",
                BigDecimal.TEN,
                "External Transfer",
                "International",
                LocalDateTime.now()
        );

        TransactionDTO[] transactionDTOS = {transactionDTO};
        System.out.println("Ollama just got the transaction by: " + id);
        return transactionDTO.toString();
    }
}
