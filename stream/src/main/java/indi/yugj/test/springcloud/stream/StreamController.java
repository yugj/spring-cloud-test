package indi.yugj.test.springcloud.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yugj
 * @date 19/1/22 19:13.
 */
@RestController
public class StreamController {

    private static final Logger log = LoggerFactory.getLogger(StreamController.class);

    @GetMapping("/stream/test")
    public Object test() {

        log.info("sleuth test");

        return "ehell";
    }
}
