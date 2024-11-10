package com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.service;

import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.dto.TransactionDTO;
import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.model.Transaction;


public interface TransactionService {

    Transaction check(TransactionDTO transactionDTO);

    String register(Transaction checkedTransaction);

    String getTransaction(String id);
}
