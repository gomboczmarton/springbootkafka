package biz.gombocz.springbootkafka.consumers;

import biz.gombocz.springbootkafka.custommessage.Greeting;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer5 {
    @KafkaListener(
            topics = "${message.custom.topic.name}",
            containerFactory = "greetingKafkaListenerContainerFactory"/*,
            groupId = "groupId2"*/) // groupId2 nem kell hozzá
    public void greetingListener(Greeting greeting) {
        System.out.println("Custom Object Message has been arrived: " + greeting);
    }
}
