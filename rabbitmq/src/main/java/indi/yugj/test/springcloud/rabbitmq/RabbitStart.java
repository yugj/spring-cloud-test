package indi.yugj.test.springcloud.rabbitmq;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Description:
 * Created by yugj on 18/7/10 14:20.
 */
@SpringBootApplication
public class RabbitStart {

    public static void main(String[] args) {
        SpringApplication.run(RabbitStart.class, args);
    }

    /**
     * 配置json转换 spring体系处理mq json 需要
     * @return MessageConverter
     */
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
