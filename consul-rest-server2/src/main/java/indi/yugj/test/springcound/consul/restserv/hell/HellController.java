package indi.yugj.test.springcound.consul.restserv.hell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yugj
 * @date 18/10/16 16:31.
 */
@RestController
@RequestMapping("/consul/rest-serv")
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

}
