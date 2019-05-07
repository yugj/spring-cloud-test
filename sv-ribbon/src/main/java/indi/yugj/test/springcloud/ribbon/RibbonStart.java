package indi.yugj.test.springcloud.ribbon;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * Description:
 * Created by yugj on 18/7/2 17:09.
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class RibbonStart {

    public static void main(String[] args) {
        SpringApplication.run(RibbonStart.class, args).start();
    }

    @Bean
    public IRule ribbonRule() {
        return new AvailabilityFilteringRule();
    }

    @Bean
    public IPing ribbonPing() {
        return new PingUrl(false,"/info");
    }

}
