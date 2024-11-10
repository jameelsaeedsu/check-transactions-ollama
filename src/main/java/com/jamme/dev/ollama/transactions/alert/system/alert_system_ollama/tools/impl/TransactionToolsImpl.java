package com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.tools.impl;

import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.service.TransactionService;
import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.tools.TransactionTools;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.service.UserName;
import org.springframework.stereotype.Service;

@Service
public class TransactionToolsImpl implements TransactionTools {

    private final TransactionService transactionService;

    public TransactionToolsImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Tool(name = "getTransactionById",
    value = "You will be always given in the prompt a transactionId which you can pass to this tool and a transaction will be returned")
    @Override
    public String getTransactionById(@UserName String id) {
        System.out.println("Just access getTransactionById Tool and passed the id: " + id);
        return transactionService.getTransaction(id);
    }

/*
    @Tool(name = "checkIfTransactionIfSuspicious",
    value = "For each TransactionDTO that you get, you pass it into this tools and just await the response and send it back to the user")
    @Override
    public String processTransaction(TransactionDTO transactionDTO) {

        Transaction transaction = transactionService.check(transactionDTO);
        return transactionService.register(transaction);
    }

 */

}
