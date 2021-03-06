package indi.yugj.test.springcloud.ribbon;

import indi.yugj.test.springcloud.ribbon.schema.HellReq;
import indi.yugj.test.springcloud.ribbon.schema.HellResp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:test feign hystrix
 * fallback和fallbackFactory共存,优先使用fallback
 * Created by yugj on 18/7/3 14:54.
 */
@Service
@FeignClient(name = "rest-server")
public interface HellStub {

    /**
     * test feign client http post
     * @param req req
     * @return resp
     */
    @RequestMapping("/rest-sv/hell")
    HellResp hell(@RequestBody HellReq req);

}
