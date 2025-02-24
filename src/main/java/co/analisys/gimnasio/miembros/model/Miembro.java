package co.analisys.gimnasio.miembros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Miembro {
    @EmbeddedId
    private MiembroID id;
    private String nombre;
    private String email;
    private LocalDate fechaInscripcion;
}
