package co.analisys.gimnasio.miembros.controller;

import co.analisys.gimnasio.miembros.dto.PagoDTO;
import co.analisys.gimnasio.miembros.service.PagoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
@Tag(name = "Pagos", description = "Gestión de pagos de miembros")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @Operation(summary = "Realizar un pago", description = "Procesa un pago para un miembro.")
    @PostMapping
    public String realizarPago(@RequestBody PagoDTO pagoDTO) {
        pagoService.procesarPago(pagoDTO);
        return "Pago enviado para el miembro " + pagoDTO.getIdMiembro();
    }
}
