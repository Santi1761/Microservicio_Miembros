package co.analisys.gimnasio.miembros.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MiembroID implements Serializable {
    private String id;

    public MiembroID() {}

    public MiembroID(String id) {
        this.id = id;
    }
}