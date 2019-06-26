package biz.gombocz.springbootkafka.consumers;

public class KafkaConsumer4 {
    /*
    @KafkaListener(topics = "mytopic", groupId = "groupId")
    public void listen(String message) {
        System.out.println("Received Message in group foo: " + message);
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
