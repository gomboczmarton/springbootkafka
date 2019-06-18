package biz.gombocz.springbootkafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "mytopic", groupId = "groupId")
    public void listen(String message) {
        System.out.println("Received Message in group foo: " + message);
    }

    /**
     * Multiple listeners can be implemented for a topic, each with a different group Id. Furthermore, one consumer can listen for messages from various topics:
     */
    @KafkaListener(topics = "topic1, topic2", groupId = "groupId")
    public void listenMultipleTopics(String message) {
        System.out.println("Received Message in group groupId: " + message);
    }

    @KafkaListener(topics = "mytopic")
    public void listenWithHeaders(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(
                "Received Message: " + message + "from partition: " + partition);
    }
}
