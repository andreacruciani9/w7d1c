package it.epicode.w7d1c.controller;

import io.jsonwebtoken.Jwts;
import it.epicode.w7d1c.exception.BadRequestException;
import it.epicode.w7d1c.exception.LoginFaultException;
import it.epicode.w7d1c.model.Dipendente;
import it.epicode.w7d1c.model.LoginRequest;
import it.epicode.w7d1c.security.JwtTools;
import it.epicode.w7d1c.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
@Autowired
private DipendenteService dipendenteService;
    @Autowired
    private JwtTools jwtTools;



    @PostMapping("/auth/login")
    public String login(@RequestBody @Validated LoginRequest loginRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        Dipendente dipendente = dipendenteService.getDipendenteByEmail(loginRequest.getEmail());

        if(dipendente.getPassword().equals(loginRequest.getPassword())){
            return jwtTools.createToken(dipendente);
        }
        else{
            throw new LoginFaultException("username/password errate");
        }

    }
}
