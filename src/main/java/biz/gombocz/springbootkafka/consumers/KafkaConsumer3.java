package biz.gombocz.springbootkafka.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer3 {

    /**
     * As you may have noticed, we had created the topic baeldung with only one partition. However, for a topic with multiple partitions,
     * a @KafkaListener can explicitly subscribe to a particular partition of a topic with an initial offset:
     * This Listener runs always. This listener is consuming all messages from the given topic without explicit new message productin by any producer.
     */
    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "${message.topic.name}",
                    partitionOffsets = {
                            @PartitionOffset(partition = "0", initialOffset = "0"), // modifying this number you will see different number of "Received Messasge" message apperance
                            @PartitionOffset(partition = "3", initialOffset = "0")
                    }))
    public void listenToPartition(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Messasge: " + message + " from partition: " + partition);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "${message.topic.name}", partitions = {"0", "1"}))
    public void listenToPartitions(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Multiple partitions without offsets: " + message + " from partition: " + partition);
    }
}
