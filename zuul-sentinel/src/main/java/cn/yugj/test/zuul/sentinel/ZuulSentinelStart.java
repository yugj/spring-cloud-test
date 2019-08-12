package cn.yugj.test.zuul.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author yugj
 * @date 18/11/20 22:20.
 */
@SpringBootApplication
@EnableZuulProxy
@ServletComponentScan
public class ZuulSentinelStart {

    public static void main(String[] args) {
        SpringApplication.run(ZuulSentinelStart.class, args).start();
    }
}
