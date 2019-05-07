package indi.yugj.springcloud.zipkin.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description:
 * Created by yugj on 18/6/1 15:34.
 */
@SpringBootApplication
@EnableEurekaClient
public class ZipkinClientStart {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinClientStart.class, args);
    }
}
