package com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.service;

import com.jamme.dev.ollama.transactions.alert.system.alert_system_ollama.model.ChatResponse;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.UserName;

public interface Worker {

    @SystemMessage("""
                        Your job is to read each transaction and decide is it is deemed as suspicious or not, and it's completely up to you. 
            
            You are required to always answer extensively on why you have decided on why a transaction is SUS or NOT_SUS           
            Always explain the thought process
             """
    )


    ChatResponse chat(@UserName String id, @UserMessage String questions);


}
