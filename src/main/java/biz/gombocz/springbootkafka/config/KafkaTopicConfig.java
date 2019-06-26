package biz.gombocz.springbootkafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    @Value(value = "${kafka.bootstrapAddress}")
    public String bootstrapAddress;

    @Value(value = "${custom.topics.one}")
    public String customTopic1;

    @Value(value = "${custom.topics.two}")
    public String customTopic2;

    @Value(value = "${message.custom.topic.name}")
    public String myCustomTopic;



    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    /**
     * When application is running, it creates this new topic automatically.
     * If topic is already existing, then nothing happens - idempotent operation.
     */
    @Bean
    public NewTopic topic1() {
        return new NewTopic(customTopic1, 1, (short) 1);
    }

    @Bean
    public NewTopic topic2() {
        return new NewTopic(customTopic2, 1, (short) 1);
    }

    @Bean
    public NewTopic topicCustom() {
        return new NewTopic(myCustomTopic, 1, (short) 1);
    }
}
