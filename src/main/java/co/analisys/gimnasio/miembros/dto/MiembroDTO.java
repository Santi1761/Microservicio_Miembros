package co.analisys.gimnasio.miembros.dto;

import co.analisys.gimnasio.miembros.model.MiembroID;
import lombok.Data;
import java.time.LocalDate;

@Data
public class MiembroDTO {
    private MiembroID id;
    private String nombre;
    private String email;
    private LocalDate fechaInscripcion;

    public MiembroDTO(MiembroID id, String nombre, String email, LocalDate fechaInscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaInscripcion = fechaInscripcion;
    }
}