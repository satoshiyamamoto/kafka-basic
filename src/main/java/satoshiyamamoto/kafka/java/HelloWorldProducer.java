package satoshiyamamoto.kafka.java;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class HelloWorldProducer {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "HelloWorldProducer");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
			producer.send(new ProducerRecord<>("test", "This is a message")).get();
			producer.send(new ProducerRecord<>("test", "This is another message")).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
