package it.epicode.w7d1c.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Dipendente {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    private String username;
    private String nome;
    private String cognome;
    @Column(unique = true)
    private  String email;
    @JsonIgnore
    @OneToMany(mappedBy = "dipendente")
    private List<Dispositivo> dispositivos;
    private String avatar;
    private String password;

    public Dipendente(String username, String nome, String cognome,String email,String password) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email=email;
        this.password=password;
        List<Dispositivo> dispositivos = new ArrayList<>();
    }
    public Dipendente(){}


}
