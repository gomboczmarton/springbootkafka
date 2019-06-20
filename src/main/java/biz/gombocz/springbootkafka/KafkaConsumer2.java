package biz.gombocz.springbootkafka;

import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer2 {

    /*
    @KafkaListener(topics = "mytopic", groupId = "groupId")
    public void listen(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
    */

    /**
     * Multiple listeners can be implemented for a topic, each with a different group Id. Furthermore, one consumer can listen for messages from various topics:
     */
    /*
    @KafkaListener(topics = "topic1, topic2", groupId = "groupId")
    public void listenMultipleTopics(String message) {
        System.out.println("Received Message in group groupId: " + message);
    }
     */


    /**
     * As you may have noticed, we had created the topic baeldung with only one partition. However, for a topic with multiple partitions,
     * a @KafkaListener can explicitly subscribe to a particular partition of a topic with an initial offset:
     */
    /*
    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "topicName",
                    partitionOffsets = {
                            @PartitionOffset(partition = "0", initialOffset = "0"),
                            @PartitionOffset(partition = "3", initialOffset = "0")
                    }))
    public void listenToPartition(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Messasge: " + message + " from partition: " + partition);
    }
    */

    /**
     * Since the initialOffset has been sent to 0 in this listener, all the previously consumed messages from partitions 0 and three will be re-consumed
     * every time this listener is initialized. If setting the offset is not required,
     * we can use the partitions property of @TopicPartition annotation to set only the partiKafkaListenerContainerFactoryKafkaListenerContainerFactorytions without the offset:
     */
    /*
    @KafkaListener(topicPartitions
            = @TopicPartition(topic = "topicName", partitions = { "0", "1" }))
    public void listenToPartitionWithoutOffset(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Messasge: " + message + " from partition: " + partition);
    }

    @KafkaListener(
            topics = "topicName",
            containerFactory = "filterKafkaListenerContainerFactory")
    public void listenFiltered(String message) {
        // handle message
    }
    */
}
