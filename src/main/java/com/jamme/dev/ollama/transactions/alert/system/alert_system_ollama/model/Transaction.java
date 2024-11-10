package com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.constants.Status;
import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.constants.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    @JsonProperty("transaction_message")
    private final String transactionMessage;

    @JsonProperty("account_number")
    private final String accountNumber;

    @JsonProperty("amount")
    private final BigDecimal amount;

    @JsonProperty("transaction_type")
    private final TransactionType transactionType;

    @JsonProperty("status")
    private final Status status;

    @JsonProperty("flagged")
    private final Boolean flagged;

    @JsonProperty("reason_for_flag")
    private final String reasonForFlag;

    @JsonProperty("country")
    private final String country;

    @JsonProperty("transaction_date")
    private final LocalDateTime transactionDate;

    @JsonCreator
    public Transaction(String transactionMessage,
                       String accountNumber,
                       BigDecimal amount,
                       TransactionType transactionType,
                       Status status,
                       Boolean flagged,
                       String reasonForFlag,
                       String country,
                       LocalDateTime transactionDate) {
        this.transactionMessage = transactionMessage;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.status = status;
        this.flagged = flagged;
        this.reasonForFlag = reasonForFlag;
        this.country = country;
        this.transactionDate = transactionDate;
    }
}
