package indi.yugj.test.springcound.consul.restserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yugj
 * @date 18/10/16 16:05.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulRestServer {

    public static void main(String[] args) {
        SpringApplication.run(ConsulRestServer.class, args);
    }
}
