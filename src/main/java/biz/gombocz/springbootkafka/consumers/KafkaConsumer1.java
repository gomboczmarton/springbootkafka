package biz.gombocz.springbootkafka.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer1 {
    @KafkaListener(topics = "#{'${message.topic.name}'}")
    public void listenWithHeaders(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("methodName: listenWithHeaders, Received Message: " + message + " from partition: " + partition);
    }
}
