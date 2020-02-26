package consulgrpcclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yugj
 * @date 2020/2/26 16:05.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulGrpcClientStart {

    public static void main(String[] args) {
        SpringApplication.run(ConsulGrpcClientStart.class, args);
    }
}
