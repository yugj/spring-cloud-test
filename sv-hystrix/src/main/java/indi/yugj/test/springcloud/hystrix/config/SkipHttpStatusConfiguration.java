package indi.yugj.test.springcloud.hystrix.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置忽略特定http 错误请求
 *
 * @author yugj
 * @date 2018/12/29 下午5:19.
 */
@Configuration
public class SkipHttpStatusConfiguration {


    @Bean
    public SkipHttpStatusErrorDecoder errorDecoder() {
        return new SkipHttpStatusErrorDecoder();
    }

}
