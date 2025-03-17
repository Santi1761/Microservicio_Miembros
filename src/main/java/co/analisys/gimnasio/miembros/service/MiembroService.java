package co.analisys.gimnasio.miembros.service;

import co.analisys.gimnasio.miembros.dto.MiembroDTO;
import co.analisys.gimnasio.miembros.dto.PagoDTO;
import co.analisys.gimnasio.miembros.model.Miembro;
import co.analisys.gimnasio.miembros.model.MiembroID;
import co.analisys.gimnasio.miembros.repository.MiembroRepository;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Service
public class MiembroService implements IMiembroService {

    @Autowired
    private MiembroRepository miembroRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public MiembroDTO registrar(MiembroDTO miembroDTO) {

        Miembro miembro = new Miembro(new MiembroID(miembroDTO.getId()),
                miembroDTO.getNombre(),
                miembroDTO.getEmail(),
                miembroDTO.getFechaInscripcion()
        );
        miembroRepository.save(miembro);

        // Se envia notificación a RabbitMQ
        rabbitTemplate.convertAndSend(
                "gimnasio.exchange",
                "inscripcion.nueva",
                miembroDTO
        );
        return miembroDTO;
    }

    @Override
    public List<MiembroDTO> obtenerMiembros() {
        return miembroRepository.findAll().stream()
                .map(miembro -> new MiembroDTO(miembro.getId().getId(),
                        miembro.getNombre(),
                        miembro.getEmail(),
                        miembro.getFechaInscripcion()
                ))
                .collect(Collectors.toList());
    }

    @RabbitListener(queues = "inscripciones.queue")
    public void procesarInscripcion(MiembroDTO miembro) {
        System.out.println("Notificación recibida de nueva inscripción: " + miembro.getNombre());
    }

    @RabbitListener(queues = "horarios.queue")
    public void recibirCambioHorario(String mensaje) {
        System.out.println("Notificación recibida: " + mensaje);
    }


    @RabbitListener(queues = "pagos-queue")
    public void procesarPago(PagoDTO pago) {
        try {
            System.out.println("Procesando pago de: $" + pago.getMonto() + " para el miembro " + pago.getIdMiembro());

            if (Math.random() > 0.5) { // Simulación de fallo en pago
                throw new RuntimeException("Error en el pago");
            }

            System.out.println("Pago procesado correctamente para el miembro: " + pago.getIdMiembro());

        } catch (Exception e) {
            System.out.println("Error en el pago. Enviando a DLQ.");
            throw new AmqpRejectAndDontRequeueException("Error en el pago, enviando a DLQ", e);
        }
    }


}