package indi.yugj.test.springclound.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author yugj
 * @date 19/1/22 19:43.
 */
public interface HellProcessor {

    /**
     * input test
     * @return
     */
    @Input("inputHell")
    SubscribableChannel inputHell();

    /**
     * output test
     * @return
     */
    @Output("outputHell")
    MessageChannel outputHell();
}
