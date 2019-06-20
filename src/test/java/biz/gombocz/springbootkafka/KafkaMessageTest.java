package biz.gombocz.springbootkafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = SpringbootkafkaApplication.class)
public class KafkaMessageTest {

    @Autowired
    private KafkaProducer producer;
    @Autowired
    private KafkaConsumer1 consumer;

    @Test
    public void testMessageSend() {
        producer.sendMessage("wakacuka");
    }
}
