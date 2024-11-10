package com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.service.impl;

import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.model.ChatRequest;
import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.model.ChatResponse;
import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.service.GenAIService;
import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.service.Worker;
import org.springframework.stereotype.Service;

@Service
public class GenAIServiceImpl implements GenAIService {

    private final Worker worker;

    public GenAIServiceImpl(Worker worker) {
        this.worker = worker;
    }


    @Override
    public String getResponse(ChatRequest chatRequest) {
        System.out.println("Checking the incoming prompt: " + chatRequest.prompt());
        ChatResponse chatResponse = worker.chat(chatRequest.id(), chatRequest.prompt());
        System.out.println("My answer is: " + chatResponse.answer());
        return chatResponse.answer();
    }
}
