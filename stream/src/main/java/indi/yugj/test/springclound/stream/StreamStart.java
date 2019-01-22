package indi.yugj.test.springclound.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableBinding({Sink.class,Source.class,HellProcessor.class})
public class StreamStart implements CommandLineRunner {

    @Autowired
    @Qualifier("output")
    MessageChannel output;

    @Autowired
    @Qualifier("outputHell")
    MessageChannel outputHell;

    public static void main(String[] args) {
        SpringApplication.run(StreamStart.class, args);
    }

    /**
     * test send
     * @param args no use
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

        System.out.println("send hell");

        output.send(MessageBuilder.withPayload("hell").build());

        outputHell.send(MessageBuilder.withPayload("outputHell").build());
    }
}
