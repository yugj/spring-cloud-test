package indi.yugj.test.springclound.hystrix.feign;

import indi.yugj.test.springclound.hystrix.hell.schema.HellReq;
import indi.yugj.test.springclound.hystrix.hell.schema.HellResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Description:
 * Created by yugj on 18/7/3 15:09.
 */
@Component
public class HellFallback implements HellStub{

    private static final Logger LOGGER = LoggerFactory.getLogger(HellFallback.class);

    @Override
    public HellResp hell(@RequestBody HellReq req) {

        LOGGER.warn("hell fallback ---->>>>> ");

        HellResp resp = new HellResp();
        resp.setHellResp("fallback error");

        return resp;
    }

    @Override
    public HellResp good(@RequestBody HellReq req) {
        return null;
    }
}
