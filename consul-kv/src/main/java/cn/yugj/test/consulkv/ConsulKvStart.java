package cn.yugj.test.consulkv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yugj
 * @date 2020/2/26 19:41.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulKvStart {

    public static void main(String[] args) {
        SpringApplication.run(ConsulKvStart.class, args);
    }
}
