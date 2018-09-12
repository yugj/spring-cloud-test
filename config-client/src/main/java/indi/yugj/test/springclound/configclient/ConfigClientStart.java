package indi.yugj.test.springclound.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * Description:test rest controller
 * Created by yugj on 18/7/2 16:58.
 */
@SpringCloudApplication
@EnableAutoConfiguration
public class ConfigClientStart {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientStart.class, args);
    }
}
