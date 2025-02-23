package co.analisys.gimnasio.miembros.repository;

import co.analisys.gimnasio.miembros.model.Miembro;
import co.analisys.gimnasio.miembros.model.MiembroID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiembroRepository extends JpaRepository<Miembro, MiembroID> {
}
