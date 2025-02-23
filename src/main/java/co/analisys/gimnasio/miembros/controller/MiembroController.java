package co.analisys.gimnasio.miembros.controller;

import co.analisys.gimnasio.miembros.dto.MiembroDTO;
import co.analisys.gimnasio.miembros.service.IMiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/miembros")
public class MiembroController {

    @Autowired
    private IMiembroService miembroService;

    @PostMapping
    public MiembroDTO registrarMiembro(@RequestBody MiembroDTO miembroDTO) {
        return miembroService.registrar(miembroDTO);
    }

    @GetMapping
    public List<MiembroDTO> obtenerTodosMiembros() {
        return miembroService.obtenerMiembros();
    }
}
