package it.epicode.w7d1c.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @Email(message = "username obbligatorio")
    private String email;
    @NotBlank(message = "password obbligatoria")
    private String password;
}
