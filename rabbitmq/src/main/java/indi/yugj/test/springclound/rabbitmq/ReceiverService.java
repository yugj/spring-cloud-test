package indi.yugj.test.springclound.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Created by yugj on 18/7/10 14:23.
 */
@Component
public class ReceiverService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverService.class);

    @RabbitHandler
    @RabbitListener(queues = "q.hell")
    public void process(String msg) {
        LOGGER.info("receive msg :" + msg);
    }
}
