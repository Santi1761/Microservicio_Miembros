package co.analisys.gimnasio.miembros.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MiembroDTO {
    private Long id;
    private String nombre;
    private String email;
    private LocalDate fechaInscripcion;

    public MiembroDTO(Long id, String nombre, String email, LocalDate fechaInscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaInscripcion = fechaInscripcion;
    }
}