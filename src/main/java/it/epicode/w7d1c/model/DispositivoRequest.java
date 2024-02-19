package it.epicode.w7d1c.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DispositivoRequest {
    @NotNull(message = "stato dispositivo obbligatorio")
    private StatoDispositivo statoDispositivo;
    @NotNull(message = "tipo dispositivo obbligatorio")
    private TipoDispositivo tipoDispositivo;
    @NotNull(message = "dipendente obbligatorio")
    private Integer idDipendente;


}
