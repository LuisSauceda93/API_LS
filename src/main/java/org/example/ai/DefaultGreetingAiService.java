package org.example.ai;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!dev")
public class DefaultGreetingAiService implements GreetingAiService {

    @Override
    public String generateGreeting() {
        return "Hola Luis Sauceda! Activa el perfil 'dev' para responder con LangChain4j.";
    }
}
