package org.example.user.service;

import org.example.user.persistence.entity.User;
import org.example.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void createShouldSaveUserWithCreationDate() {
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            savedUser.setId(1L);
            return savedUser;
        });

        User result = userService.create("Luis Sauceda", "luis@example.com");

        assertEquals(1L, result.getId());
        assertEquals("Luis Sauceda", result.getName());
        assertEquals("luis@example.com", result.getEmail());
        assertNotNull(result.getCreatedAt());
        verify(userRepository).save(any(User.class));
    }
}
