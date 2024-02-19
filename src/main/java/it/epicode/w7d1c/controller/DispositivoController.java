package it.epicode.w7d1c.controller;

import it.epicode.w7d1c.exception.BadRequestException;
import it.epicode.w7d1c.model.Dispositivo;
import it.epicode.w7d1c.model.DispositivoRequest;
import it.epicode.w7d1c.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
public class DispositivoController {
    @Autowired
    private DispositivoService dispositivoService;

    @GetMapping("/dispositivi")
    public Page<Dispositivo> getAll(Pageable pageable){
        return dispositivoService.getAllDisposit(pageable);
    }
    @GetMapping("/dispositivi/{id}")
    public  Dispositivo getDispositivoById(@PathVariable int id){
        return dispositivoService.getDispositivoId(id);
    }
    @PostMapping("/dispositivi")
    public  Dispositivo saveDispositivo(@RequestBody @Validated DispositivoRequest dispositivoRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
               throw  new BadRequestException(bindingResult.getAllErrors().toString());
        }
        return  dispositivoService.saveDispositivo(dispositivoRequest);
    }
    @PutMapping("/dispositivi/{id}")
    public  Dispositivo updateDispositivo(@PathVariable int id , @RequestBody @Validated DispositivoRequest dispositivoRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        } return dispositivoService.refreshDispositivo(id,dispositivoRequest);
    }
    @DeleteMapping("/dispositivi/{id}")
    public  void  deleteDispositivi(@PathVariable int id){
        dispositivoService.delete(id);
    }
}
