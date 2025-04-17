package co.analisys.gimnasio.miembros.service;

import co.analisys.gimnasio.miembros.dto.PagoDTO;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PagoService {

    private final RabbitTemplate rabbitTemplate;

    public PagoService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void procesarPago(PagoDTO pagoDTO) {
        System.out.println("Enviando pago de " + pagoDTO.getMonto() + " para el miembro " + pagoDTO.getIdMiembro());

        rabbitTemplate.convertAndSend(
                "gimnasio.exchange",
                "pagos.procesar",
                pagoDTO
        );
    }

    @RabbitListener(queues = "pagos-queue")
    public void recibirPago(PagoDTO pagoDTO) {
        try {
            System.out.println("Procesando pago de: " + pagoDTO.getMonto() + " para " + pagoDTO.getIdMiembro());

            // Simulación de fallo en pagos
            if (pagoDTO.getMonto() % 2 == 0) {
                throw new RuntimeException("Error: Fallo en el procesamiento del pago.");
            }

            System.out.println("Pago procesado con éxito para " + pagoDTO.getIdMiembro());

        } catch (Exception e) {
            System.out.println("Error en el pago, enviando a DLQ...");
            throw new AmqpRejectAndDontRequeueException("Error en el pago, enviando a DLQ", e);
        }
    }
}
