package co.analisys.gimnasio.miembros.controller;

import co.analisys.gimnasio.miembros.model.Miembro;
import co.analisys.gimnasio.miembros.service.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miembros")
public class MiembroController {

    @Autowired
    private MiembroService miembroService;

    @PostMapping
    public Miembro registrarMiembro(@RequestBody Miembro miembro) {
        return miembroService.registrar(miembro);
    }

    @GetMapping
    public List<Miembro> obtenerTodosMiembros() {
        return miembroService.obtenerMiembros();
    }
}
