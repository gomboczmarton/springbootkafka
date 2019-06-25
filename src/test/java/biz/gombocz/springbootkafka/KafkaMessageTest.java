package biz.gombocz.springbootkafka;

import biz.gombocz.springbootkafka.consumers.KafkaConsumer1;
import biz.gombocz.springbootkafka.producer.KafkaProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = SpringbootkafkaApplication.class)
public class KafkaMessageTest {
    @Value(value = "${custom.topics.one}")
    public String customTopic1;
    @Value(value = "${custom.topics.two}")
    public String customTopic2;
    @Value(value = "${message.topic.name}")
    public String mytopic;

    @Autowired
    private KafkaProducer producer;
    @Autowired
    private KafkaConsumer1 consumer;

    @Test
    public void testMessageSend() {
        producer.sendMessage("wakacuka", mytopic);
    }

    @Test
    public void testMultipleTopicMessageSend() {
        producer.sendMessage("multiple_wakacuka", customTopic1);
        producer.sendMessage("multiple_wakacuka", customTopic2);
    }
}
