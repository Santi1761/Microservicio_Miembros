package co.analisys.gimnasio.miembros.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Miembro {
    @EmbeddedId
    private MiembroID id;

    private String nombre;
    private String email;
    private LocalDate fechaInscripcion;

    public Miembro(MiembroID id, String nombre, String email, LocalDate fechaInscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Miembro() {
    }

    public MiembroID getId() {
        return id;
    }

    public void setId(MiembroID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
