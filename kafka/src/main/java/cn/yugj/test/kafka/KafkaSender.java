package cn.yugj.test.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author yugj
 * @date 2019/3/4 下午4:49.
 */
public class KafkaSender {

    public static void main(String[] args) {

        KafkaSender sender = new KafkaSender();
        KafkaProducer producer = sender.getProducer();

        String data = "test";

        for (int i = 1; i <= 120; i++) {
//            producer.send(new ProducerRecord<String, String>("t-hell", "" + 1, data));
            sender.send("t-hell","",data);
        }

        producer.close();
    }



    private KafkaProducer getProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

        return producer;
    }

    public void send(String topic, String key, String data) {

        KafkaProducer producer = getProducer();

        for (int i = 1; i < 2; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            producer.send(new ProducerRecord<String, String>(topic, "" + i, data));
        }
        producer.close();
    }
}
