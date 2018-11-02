package indi.yugj.test.springclound.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Description:
 * Created by yugj on 18/7/2 17:09.
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class RibbonStart {

    public static void main(String[] args) {
        SpringApplication.run(RibbonStart.class, args);
    }

}
