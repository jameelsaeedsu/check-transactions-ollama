package com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.config;

import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.service.Worker;
import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.tools.TransactionTools;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class OllamaConfig {

    private final TransactionTools transactionTools;

    public OllamaConfig(TransactionTools transactionTools) {
        this.transactionTools = transactionTools;
    }

    @Bean
    public Worker assistant() {
        return AiServices.builder(Worker.class)
                .chatLanguageModel(ollamaChatModel())
                .tools(transactionTools)
                .build();
    }

    @Bean
    public OllamaChatModel ollamaChatModel() {
        return OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("llama3.2")
                .temperature(0.8)
                .timeout(Duration.ofMinutes(3))
                .build();
    }



    /*
    @Bean
    public Assistant assistant(
            ChatLanguageModel chatLanguageModel,
            Tokenizer tokenizer,
            ChatMessagesService chatMessagesService
    ) {

        return AiServices.builder(Assistant.class)
                .chatLanguageModel(chatLanguageModel)
                .chatMemoryProvider(memoryId -> TokenWindowChatMemory.builder()
                        .id(memoryId)
                        .chatMemoryStore(new PersistentChatMemoryStore(chatMessagesService))
                        .maxTokens(1000, tokenizer)
                        .build())
                .tools(userTools, accountTools)
                .build();
    }

     */


}
