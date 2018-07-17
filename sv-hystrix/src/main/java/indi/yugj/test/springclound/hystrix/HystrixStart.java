package indi.yugj.test.springclound.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Description:
 * Created by yugj on 18/7/2 17:09.
 */
@SpringCloudApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class HystrixStart {

    public static void main(String[] args) {
        SpringApplication.run(HystrixStart.class, args);
    }

}
