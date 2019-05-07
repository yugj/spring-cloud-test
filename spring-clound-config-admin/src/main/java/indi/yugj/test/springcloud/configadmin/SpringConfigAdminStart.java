package indi.yugj.test.springcloud.configadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * @author yugj
 * @date 2018/12/19 下午4:48.
 */

@Configuration
@EnableAutoConfiguration
public class SpringConfigAdminStart {


    public static void main(String[] args) {
        SpringApplication.run(SpringConfigAdminStart.class, args);
    }
}
