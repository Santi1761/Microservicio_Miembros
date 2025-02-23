package co.analisys.gimnasio.miembros.service;

import co.analisys.gimnasio.miembros.dto.MiembroDTO;
import java.util.List;

public interface IMiembroService {
    MiembroDTO registrar(MiembroDTO miembroDTO);
    List<MiembroDTO> obtenerMiembros();
}
