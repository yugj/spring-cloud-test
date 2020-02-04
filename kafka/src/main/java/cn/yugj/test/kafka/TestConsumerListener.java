package cn.yugj.test.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 */
@Component
public class TestConsumerListener {

    private static final Logger logger = LoggerFactory.getLogger(TestConsumerListener.class);

    @KafkaListener(topics = {"t-hell"}, containerFactory = "kafkaListenerContainerFactory")
    public void listener(List<ConsumerRecord<?, ?>> records, Acknowledgment ack) {

        logger.info("records :{}", records);

        ack.acknowledge();
    }

}

