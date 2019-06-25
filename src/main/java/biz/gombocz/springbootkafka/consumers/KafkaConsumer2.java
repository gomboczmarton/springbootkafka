package biz.gombocz.springbootkafka.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer2 {

    /**
     * Multiple listeners can be implemented for a topic, each with a different group Id. Furthermore, one consumer can listen for messages from various topics:
     */
    @KafkaListener(topics = {"customtopic1", "customtopic2"}, groupId = "groupId")
    public void listenMultipleTopics(String message) {
        System.out.println("Multiple topics are listened by consumer: Received Message in group groupId: " + message);
    }
}
