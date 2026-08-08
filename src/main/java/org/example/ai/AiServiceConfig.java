package org.example.ai;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class AiServiceConfig {

    @Bean
    public GreetingAiService greetingAiService(ChatModel chatModel) {
        return AiServices.builder(GreetingAiService.class)
                .chatModel(chatModel)
                .build();
    }
}
