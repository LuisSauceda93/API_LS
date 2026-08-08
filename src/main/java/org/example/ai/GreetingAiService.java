package org.example.ai;

import dev.langchain4j.service.UserMessage;

public interface GreetingAiService {

    @UserMessage("""
            Genera un saludo amigable con un estilo moderno.
            """)
    String generateGreeting();
}
