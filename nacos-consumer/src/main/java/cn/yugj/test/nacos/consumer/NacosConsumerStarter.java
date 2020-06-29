package cn.yugj.test.nacos.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author yugj
 * @date 2020/6/29 3:44 下午.
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerStarter {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerStarter.class, args);
    }

}
