package cn.yugj.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yugj
 * @date 2019/1/25 下午4:58.
 */

@RestController
public class LogbackController {

    private static final Logger log = LoggerFactory.getLogger(LogbackController.class);
    private static final Logger is = LoggerFactory.getLogger("is");

    @GetMapping("/lb/test")
    public Object test() {

        int thread = 1000;
        int times = 200;

        for (int i = 0; i < thread; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    loopLog(times);
                }
            }).start();

        }

        return "ok";
    }


    private void loopLog(int times) {
        for (int i = 0; i < times; i++) {
            doLog();
        }
    }


    private void doLog() {
        is.info("hell-> logback");
    }

}
