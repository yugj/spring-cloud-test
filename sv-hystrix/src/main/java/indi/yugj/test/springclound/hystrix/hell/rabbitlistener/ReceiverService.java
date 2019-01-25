package indi.yugj.test.springclound.hystrix.hell.rabbitlistener;

import indi.yugj.test.springclound.hystrix.feign.HellStub;
import indi.yugj.test.springclound.hystrix.hell.schema.HellReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Created by yugj on 18/7/10 14:23.
 */
@Component
public class ReceiverService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverService.class);

    @Autowired
    private HellStub hellStub;

    @RabbitHandler
    @RabbitListener(queues = "q.hell")
    public void process(String msg) {
        LOGGER.info("receive msg :" + msg);

        hellStub.good(new HellReq("hell"));
    }
}
