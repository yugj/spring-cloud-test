package indi.yugj.test.springclound.restsv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description:test rest controller
 * Created by yugj on 18/7/2 16:58.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RestStart {

    public static void main(String[] args) {
        SpringApplication.run(RestStart.class, args);
    }
}
