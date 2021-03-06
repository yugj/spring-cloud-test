package indi.yugj.test.springcloud.restsv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Description:test rest controller
 * Created by yugj on 18/7/2 16:58.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
public class RestStart {

    public static void main(String[] args) {
        SpringApplication.run(RestStart.class, args);
    }
}
