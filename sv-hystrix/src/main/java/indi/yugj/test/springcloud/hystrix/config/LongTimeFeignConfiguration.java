package indi.yugj.test.springcloud.hystrix.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * Created by yugj on 18/7/11 15:50.
 */
@Configuration
public class LongTimeFeignConfiguration {

    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 60000);
    }


}
