package co.analisys.gimnasio.miembros.controller;

import co.analisys.gimnasio.miembros.dto.MiembroDTO;
import co.analisys.gimnasio.miembros.service.IMiembroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/miembros")
@Tag(name = "Miembros", description = "Gestión de miembros del gimnasio")
public class MiembroController {

    @Autowired
    private IMiembroService miembroService;

    @Operation(summary = "Registrar un nuevo miembro",
            description = "Permite registrar un nuevo miembro en el gimnasio. " +
                    "Accesible para todos los usuarios.")
    @PostMapping
    public MiembroDTO registrarMiembro(@RequestBody MiembroDTO miembroDTO) {
        return miembroService.registrar(miembroDTO);
    }

    @Operation(summary = "Obtener todos los miembros",
            description = "Permite obtener la lista de todos los miembros registrados. " +
                    "Accesible solo para administradores.")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<MiembroDTO> obtenerTodosMiembros() {
        return miembroService.obtenerMiembros();
    }
}
