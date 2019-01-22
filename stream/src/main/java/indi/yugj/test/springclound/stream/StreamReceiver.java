package indi.yugj.test.springclound.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;

/**
 * @author yugj
 * @date 2019/1/22 下午4:54.
 */
@Service
public class StreamReceiver {

    private static final Logger log = LoggerFactory.getLogger(StreamReceiver.class);

    @StreamListener(Processor.INPUT)
    public void process(String message) {

        log.info("process ------------>>" + message);
    }

    @StreamListener("inputHell")
    public void process2(String message) {
        log.info("process2 ------------>>" + message);
    }


}
