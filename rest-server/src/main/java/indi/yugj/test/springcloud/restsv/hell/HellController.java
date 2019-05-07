package indi.yugj.test.springcloud.restsv.hell;

import com.alibaba.fastjson.JSONObject;
import indi.yugj.test.springcloud.restsv.concurrent.JobHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Description:
 * Created by yugj on 18/7/2 16:59.
 */
@RestController
@RequestMapping("/rest-sv")
public class HellController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HellController.class);

    @RequestMapping("/hell")
    public HellResp hell(@RequestBody @Valid HellReq req) throws InterruptedException {

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

    @RequestMapping("/good")
    public HellResp good(@RequestBody HellReq req) {

        HellResp resp = new HellResp();
        resp.setHellResp("good");

        LOGGER.info("good");

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

    @DeleteMapping("/del")
    public String del(@RequestBody HellReq req) {

        JSONObject rs = new JSONObject();
        rs.put("hell", System.currentTimeMillis());

        LOGGER.info("del");

        return rs.toJSONString();
    }
    @PutMapping("/put")
    public String put(@RequestBody HellReq req) {

        JSONObject rs = new JSONObject();
        rs.put("hell", System.currentTimeMillis());

        LOGGER.info("put");
        return rs.toJSONString();
    }


    private String hell() throws InterruptedException {
        LOGGER.info("sleep start");
        Thread.sleep(60000L);
        LOGGER.info("sleep end");
        return "hell";
    }

}
