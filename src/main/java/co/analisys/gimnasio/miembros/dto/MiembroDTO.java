package co.analisys.gimnasio.miembros.dto;

import co.analisys.gimnasio.miembros.model.MiembroID;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MiembroDTO {
    private String id;
    private String nombre;
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaInscripcion;
}
