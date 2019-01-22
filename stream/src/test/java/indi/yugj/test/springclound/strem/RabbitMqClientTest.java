package indi.yugj.test.springclound.strem;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

/**
 * @author yugj
 * @date 2019/1/14 下午5:12.
 */
public class RabbitMqClientTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqClientTest.class);

    public static void main(String[] args) {

        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();

        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        JSONObject message = new JSONObject();
        message.put("userId", 888);

        String queueName = "q.hell.yugj";

        LOGGER.info("[rabbit mq send] queue:{},message:{}", queueName, message.toJSONString());

        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend("ex.bizRouter", queueName, message.toJSONString());

        System.exit(0);

    }

}
