package com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.service;


import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.model.ChatRequest;

public interface GenAIService {

    String getResponse(ChatRequest chatRequest);
}
