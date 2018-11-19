package indi.yugj.test.springclound.restsv.hell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author yugj
 * @date 2018/11/19 上午11:11.
 */
@RestController
public class ExecutorWithSleuthTest {

    private static ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(10);

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorWithSleuthTest.class);

    @RequestMapping("executor")
    public String execute() {

        LOGGER.info("main log");

        new Thread(() ->
                LOGGER.info("thread log")
        ).start();

        executor.submit(() -> {
            LOGGER.info("executor log");
        });

        return "hell";

    }


}
