package org.dododo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "my-topic", groupId = "dododo")
    public void listenDododo(String message) {
        logger.info("listenDododo | Received message: " + message);
    }

    @KafkaListener(topics = "my-topic", groupId = "winnie")
    public void listenWinnie(String message) {
        logger.debug("listenWinnie | Received message: " + message);
    }

}
