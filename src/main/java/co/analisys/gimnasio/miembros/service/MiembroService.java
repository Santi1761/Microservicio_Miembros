package co.analisys.gimnasio.miembros.service;

import co.analisys.gimnasio.miembros.model.Miembro;
import co.analisys.gimnasio.miembros.repository.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MiembroService {

    @Autowired
    private MiembroRepository miembroRepository;

    public Miembro registrar(Miembro miembro) {
        return miembroRepository.save(miembro);
    }

    public List<Miembro> obtenerMiembros() {
        return miembroRepository.findAll();
    }
}
