package indi.yugj.test.springclound.restsv.hell;

import indi.yugj.test.springclound.restsv.concurrent.JobHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Created by yugj on 18/7/2 16:59.
 */
@RestController
@RequestMapping("/rest-sv")
public class HellController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HellController.class);

    @RequestMapping("/hell")
    public HellResp hell(@RequestBody HellReq req) throws InterruptedException {

        long start = System.currentTimeMillis();

        if (null != req && "sleep".equals(req.getHellReq())) {
            Thread.sleep(5000L);
        }

        if ("error".equals(req.getHellReq())) {
            throw new RuntimeException("hell error");
        }

        LOGGER.info("hell req : " + req.getHellReq());

        HellResp resp = new HellResp();
        resp.setHellResp("rest-sv resp,hell req: " + req.getHellReq());

        long end = System.currentTimeMillis();


        LOGGER.info("exe time:" + (end - start));

        return resp;
    }

    @RequestMapping(method = RequestMethod.POST, params = "txcode=idfaActive")
    public HellResp hell2(@RequestBody HellReq req) throws InterruptedException {

        HellResp resp = new HellResp();
        resp.setHellResp("rest-sv resp,hell req: " + req.getHellReq());

        return resp;
    }

    @RequestMapping("/shutdownTest")
    public String shutdownTest() {

        JobHelper.EXECUTOR_SERVICE.shutdown();

        return "success";
    }


    @RequestMapping("/submitJob")
    public String submitJob() {
        JobHelper.submit(() -> hell());
        return "success";
    }

    @RequestMapping("/sleep")
    public String sleep() throws InterruptedException {

        LOGGER.info("sleep 60s start");

        Thread.sleep(60000L);

        LOGGER.info("sleep end");

        return "success";
    }




    private String hell() throws InterruptedException {
        LOGGER.info("sleep start");
        Thread.sleep(60000L);
        LOGGER.info("sleep end");
        return "hell";
    }

}
