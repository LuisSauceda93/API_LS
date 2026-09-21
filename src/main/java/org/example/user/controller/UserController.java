package org.example.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.user.persistence.entity.User;
import org.example.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con usuarios")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(
            summary = "Obtener todos los usuarios",
            description = "Devuelve la lista completa de usuarios registrados"

    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuarios encontrados",
                    content = @Content(
                            array = @ArraySchema(
                                    schema = @Schema(implementation = User.class)
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content
            )
    })
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping
    @Operation(
            summary = "Registrar un usuario",
            description = "Crea un usuario y asigna automáticamente la fecha de creación"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Usuario creado",
                    content = @Content(schema = @Schema(implementation = User.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Nombre o correo inválido",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content
            )
    })
    public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateRequest request) {
        User createdUser = userService.create(request.name(), request.email());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
