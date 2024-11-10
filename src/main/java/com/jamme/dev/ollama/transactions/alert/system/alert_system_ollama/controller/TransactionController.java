package com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.controller;

import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.model.ChatRequest;
import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.model.ChatResponse;
import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.service.GenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TransactionController.PATH)
public class TransactionController {

    public static final String PATH = "/api/v1/chat";

    private final GenAIService genAIService;

    public TransactionController(GenAIService genAIService) {
        this.genAIService = genAIService;
    }

    @PostMapping
    public ChatResponse checkTransaction(@RequestBody ChatRequest chatRequest) {
        return new ChatResponse(genAIService.getResponse(chatRequest));
    }

}
