package indi.yugj.test.springclound.hystrix.feign;

import indi.yugj.test.springclound.hystrix.config.SkipHttpStatusConfiguration;
import indi.yugj.test.springclound.hystrix.hell.schema.HellReq;
import indi.yugj.test.springclound.hystrix.hell.schema.HellResp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yugj
 * @date 2018/12/29 下午5:27.
 */
@Service
@FeignClient(name = "rest-server"
        ,fallback = HellFallback.class
        ,fallbackFactory = HellFallbackFactory.class,configuration = SkipHttpStatusConfiguration.class)
public interface Skip400Stub {

    /**
     * test feign client http post
     * @param req req
     * @return resp
     */
    @RequestMapping("/rest-sv/hell")
    HellResp hell(@RequestBody HellReq req);


    @RequestMapping("/rest-sv/good")
    HellResp good(@RequestBody HellReq req);
}
