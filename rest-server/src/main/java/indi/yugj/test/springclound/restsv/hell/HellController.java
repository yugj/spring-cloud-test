package indi.yugj.test.springclound.restsv.hell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

        LOGGER.info("hell req : " + req.getHellReq());

        HellResp resp = new HellResp();
        resp.setHellResp("rest-sv resp,hell req: " + req.getHellReq());

        long end = System.currentTimeMillis();


        LOGGER.info("exe time:" + (end - start));

        return resp;
    }
}
