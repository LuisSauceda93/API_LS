package org.example.user.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserCreateRequest(
        @NotBlank(message = "El nombre es obligatorio")
        @Schema(description = "Nombre del usuario", example = "Luis Sauceda")
        String name,

        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "El correo debe tener un formato válido")
        @Schema(description = "Correo electrónico", example = "luis@example.com")
        String email
) {
}
