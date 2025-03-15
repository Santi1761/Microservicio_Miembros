package co.analisys.gimnasio.miembros.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Cola para nuevas inscripciones
    @Bean
    public Queue inscripcionesQueue() {
        return new Queue("inscripciones.queue", true);
    }

    // Cola para Pagos con manejo de Dead Letter Queue (DLQ)
    @Bean
    public Queue pagosQueue() {
        return QueueBuilder.durable("pagos-queue")
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", "pagos-dlq")
                .withArgument("x-message-ttl", 30000) // 30 segundos
                .build();
    }

    // Exchange genérico para el gimnasio
    @Bean
    public TopicExchange gimnasioExchange() {
        return new TopicExchange("gimnasio.exchange");
    }

    // Binding para Inscripciones osea las notificaciones
    @Bean
    public Binding bindingInscripciones(Queue inscripcionesQueue, TopicExchange gimnasioExchange) {
        return BindingBuilder.bind(inscripcionesQueue).to(gimnasioExchange).with("inscripcion.nueva");
    }

    // Binding/cola para Cambios de Horario (Publish/Subscribe)
    @Bean
    public Queue horariosQueue() {
        return new Queue("horarios.queue", true);
    }

    @Bean
    public Binding bindingHorarios(Queue horariosQueue, TopicExchange gimnasioExchange) {
        return BindingBuilder.bind(horariosQueue()).to(gimnasioExchange).with("horarios.cambio");
    }

    // Dead Letter Queue para pagos
    @Bean
    public Queue pagosDLQ() {
        return QueueBuilder.durable("pagos-dlq").build();
    }

    // Convertidor JSON para mensajes
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // RabbitTemplate
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
