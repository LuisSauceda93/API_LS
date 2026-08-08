package org.example.ai.controller;

import org.example.ai.GreetingAiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final GreetingAiService greetingAiService;

    public HomeController(GreetingAiService greetingAiService) {
        this.greetingAiService = greetingAiService;
    }

    @GetMapping("/")
    public String home() {
        return greetingAiService.generateGreeting();
    }
}
