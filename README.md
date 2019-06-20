**Spring Boot + Kafka Example project**

1, Download Kafka from here:
http://apache.mirror.anlx.net/kafka/2.2.0/kafka_2.12-2.2.0.tgz

2, Extract it to c:\kafka_2.12-2.2.0 directory

3, Follow the instructions below:
https://kafka.apache.org/quickstart

**KAFKA WINDOWS INSTALL & CONFIG - based on Quickstart article above**

1, Optional: setup KAFKA_HOME environment variable to:
c:\kafka_2.12-2.2.0\

2, Optional: setup Path environment variable to:
%KAFKA_HOME%\bin\windows

3, Configure Zookeeper:
c:\kafka_2.12-2.2.0\config\zookeeper.properties

dataDir=c:\kafka_2.12-2.2.0\data

4, Start Zookeeper in a CMD window:
zookeeper-server-start c:\kafka_2.12-2.2.0\config\zookeeper.properties

5, Configure Kafka:
c:\kafka_2.12-2.2.0\config\server.properties

Uncomment the following line:
listeners=PLAINTEXT://:9092

Create kafka-logs directory, then:
log.dirs=c:\kafka_2.12-2.2.0\kafka-logs

6, Start Kafka in a CMD window:
kafka-server-start c:\kafka_2.12-2.2.0\config\server.properties

7, Create a Topic called "test" in Kafka:
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test

8, Check if it is created:
kafka-topics --list --bootstrap-server localhost:9092

**Test Kafka works by sending and receiving some messages** 
1, Create a producer in a CMD window:
kafka-console-producer --broker-list localhost:9092 --topic test

2, Create a consumer in a CMD window:
kafka-console-consumer --bootstrap-server localhost:9092 --topic test --from-beginning

3, Go back to producer's window and start typing then hit enter.
Messages will appear in consumer's console.