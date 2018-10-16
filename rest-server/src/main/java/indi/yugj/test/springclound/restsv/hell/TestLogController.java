package indi.yugj.test.springclound.restsv.hell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yugj
 * @date 18/10/15 14:48.
 */
@RequestMapping("/rest-serv/log")
@Controller
public class TestLogController {

    Logger asyncLog = LoggerFactory.getLogger("async");
    Logger syncLog = LoggerFactory.getLogger(TestLogController.class);

    @RequestMapping("/async")
    @ResponseBody
    public String async(@RequestParam("exe") Integer exe) {
        long cost = costLog(asyncLog,exe);
        return "async cost" + cost;
    }

    @RequestMapping("/sync")
    @ResponseBody
    public String sync(@RequestParam("exe") Integer exe) {
        long cost = costLog(syncLog,exe);
        return "sync cost" + cost;
    }

    private long costLog(Logger logger,Integer exe) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < exe; i++) {
            logger.debug("async debug");
            logger.info("async info");
            logger.warn("async warn");
        }
        long end = System.currentTimeMillis();

        long cost = end - start;

        System.out.println("cost:" + cost);

        return cost;
    }
}
