package indi.yugj.test.springclound.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class StreamStart {

    public static void main(String[] args) {
        SpringApplication.run(StreamStart.class, args);
    }
}
