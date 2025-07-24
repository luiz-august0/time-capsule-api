package time.capsule.api.infrastructure.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import time.capsule.api.core.gateway.messaging.TimeCapsuleMessagingGateway;
import time.capsule.api.infrastructure.exception.exceptions.ApplicationGenericsException;

@Slf4j
@RequiredArgsConstructor
@Service
public class TimeCapsuleMessagingService implements TimeCapsuleMessagingGateway {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topics.time-capsule-send}")
    private String timeCapsuleSendTopic;

    public void send(Long timeCapsuleId) {
        try {
            log.info("Enviando mensagem para o tópico {} com ID da cápsula: {}", timeCapsuleSendTopic, timeCapsuleId);
            
            kafkaTemplate.send(timeCapsuleSendTopic, String.valueOf(timeCapsuleId))
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        log.info("Mensagem enviada com sucesso para o tópico {} com ID: {}", timeCapsuleSendTopic, timeCapsuleId);
                    } else {
                        log.error("Erro ao enviar mensagem para o tópico {} com ID: {}", timeCapsuleSendTopic, timeCapsuleId, ex);
                    }
                });
        } catch (Exception e) {
            log.error("Erro inesperado ao enviar mensagem Kafka para ID: {}", timeCapsuleId, e);
            throw new ApplicationGenericsException("Falha ao enviar mensagem para Kafka");
        }
    }

}
