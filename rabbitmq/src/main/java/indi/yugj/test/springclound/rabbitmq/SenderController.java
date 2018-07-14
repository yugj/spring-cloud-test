package indi.yugj.test.springclound.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Created by yugj on 18/7/10 14:23.
 */
@RestController
@RequestMapping("/rabbitmq/hell")
public class SenderController {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/send")
    public String hell() {

        rabbitTemplate.convertAndSend("q.hell", "hell -- >> hell");

        return "success";
    }
}
