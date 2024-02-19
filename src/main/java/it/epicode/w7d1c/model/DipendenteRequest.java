package it.epicode.w7d1c.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class DipendenteRequest {
 @NotBlank(message = "usurname obbligatorio")
    private String username;
   @NotBlank(message = "usurname obbligatorio")
    private String nome;
   @NotBlank(message = "usurname obbligatorio")
    private String cognome;
    @Email(message = "email obbligatorio")
    private  String email;
    @NotBlank(message = "password obbligatorio")
    private String password;

    private List < Dispositivo> dispositivo;

}
