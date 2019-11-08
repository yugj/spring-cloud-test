package indi.yugj.test.springcloud.ribbon;

import indi.yugj.test.springcloud.ribbon.schema.HellReq;
import indi.yugj.test.springcloud.ribbon.schema.HellResp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yugj
 * @date 2019/11/9 06:01.
 */
@Service
@FeignClient("justribbon")
//@RibbonClient(name = "just-ribbon")
public interface JustRibbonStub {

    /**
     * test feign client http post
     * @param req req
     * @return resp
     */
    @RequestMapping("/rest-sv/hell")
    HellResp hell(@RequestBody HellReq req);
}
