package org.example.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final APIserviceAI aiService;
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository, APIserviceAI aiService) {
        this.userRepository = userRepository;
        this.aiService = aiService;
    }

    @GetMapping("/")
    public String home() {
        return this.aiService.generateGreeting();
    }

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
