package org.example.user;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface APIserviceAI {

    @UserMessage("""
            Puedes darme el clima de La Piedad Michoacan en formato moderno y en HTML con estilos basicos
            """)
    String generateGreeting();
}
