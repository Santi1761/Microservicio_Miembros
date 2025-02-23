package co.analisys.gimnasio.miembros.repository;

import co.analisys.gimnasio.miembros.model.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiembroRepository extends JpaRepository<Miembro, Long> {
}
