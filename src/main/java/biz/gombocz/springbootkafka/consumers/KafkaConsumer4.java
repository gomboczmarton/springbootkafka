package biz.gombocz.springbootkafka.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer4 {

    @KafkaListener(
            topics = "${message.topic.name}",
            containerFactory = "filterKafkaListenerContainerFactory")
    public void listenFiltered(String message) {
        System.out.println("Specific content filtered message: " + message + " that contains the word World");
    }

    /*
    @KafkaListener(topics = "mytopic", groupId = "groupId")
    public void listen(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
    */
}
