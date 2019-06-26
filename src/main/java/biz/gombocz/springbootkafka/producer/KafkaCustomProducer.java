package biz.gombocz.springbootkafka.producer;

import biz.gombocz.springbootkafka.custommessage.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaCustomProducer {
    @Autowired
    private KafkaTemplate<String, Greeting> kafkaTemplate;

    public void sendMessage(Greeting msg, String topic) {
        ListenableFuture<SendResult<String, Greeting>> future = kafkaTemplate.send(topic, msg);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Greeting>>() {

            @Override
            public void onSuccess(SendResult<String, Greeting> result) {
                System.out.println("Sent CUSTOM message=[" + msg + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send CUSTOM message=[" + msg + "] due to : " + ex.getMessage());
            }
        });
    }
}
