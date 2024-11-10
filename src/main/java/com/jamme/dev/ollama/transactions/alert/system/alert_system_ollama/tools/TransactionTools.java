package com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.tools;

import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.dto.TransactionDTO;
import dev.langchain4j.service.UserName;

public interface TransactionTools {

     //String processTransaction(TransactionDTO transactionDTO);

     String getTransactionById(@UserName String id);

}
