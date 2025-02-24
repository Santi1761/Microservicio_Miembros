package co.analisys.gimnasio.miembros.service;

import co.analisys.gimnasio.miembros.dto.MiembroDTO;
import co.analisys.gimnasio.miembros.model.Miembro;
import co.analisys.gimnasio.miembros.model.MiembroID;
import co.analisys.gimnasio.miembros.repository.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MiembroService implements IMiembroService {

    @Autowired
    private MiembroRepository miembroRepository;

    @Override
    public MiembroDTO registrar(MiembroDTO miembroDTO) {
        Miembro miembro = new Miembro(
                miembroDTO.getId(),
                miembroDTO.getNombre(),
                miembroDTO.getEmail(),
                miembroDTO.getFechaInscripcion()
        );
        miembro = miembroRepository.save(miembro);
        return new MiembroDTO(
                miembro.getId(),
                miembro.getNombre(),
                miembro.getEmail(),
                miembro.getFechaInscripcion()
        );
    }

    @Override
    public List<MiembroDTO> obtenerMiembros() {
        return miembroRepository.findAll().stream()
                .map(miembro -> new MiembroDTO(
                        miembro.getId(),
                        miembro.getNombre(),
                        miembro.getEmail(),
                        miembro.getFechaInscripcion()
                ))
                .collect(Collectors.toList());
    }
}