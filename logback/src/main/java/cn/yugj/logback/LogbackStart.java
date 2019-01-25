package cn.yugj.logback;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yugj
 * @date 2019/1/25 下午4:51.
 */
@SpringBootApplication
public class LogbackStart implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LogbackStart.class, args);
    }



    @Override
    public void run(String... args) throws Exception {

    }
}
