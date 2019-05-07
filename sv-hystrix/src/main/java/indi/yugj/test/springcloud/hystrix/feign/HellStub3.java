package indi.yugj.test.springcloud.hystrix.feign;

import indi.yugj.test.springcloud.hystrix.hell.schema.HellReq;
import indi.yugj.test.springcloud.hystrix.hell.schema.HellResp;
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
@FeignClient(name = "rest-server3", url = "http://localhost:9006")
public interface HellStub3 {

    /**
     * test feign client http post
     * @param req req
     * @return resp
     */
    @RequestMapping("/rest-sv/hell")
    HellResp hell3(@RequestBody HellReq req);

}
