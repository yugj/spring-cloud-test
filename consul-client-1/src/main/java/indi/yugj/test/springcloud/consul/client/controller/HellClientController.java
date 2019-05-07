package indi.yugj.test.springcloud.consul.client.controller;

import indi.yugj.test.springcloud.consul.client.feign.HellStub;
import indi.yugj.test.springcloud.consul.client.schema.HellReq;
import indi.yugj.test.springcloud.consul.client.schema.HellResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:测试类,触发入口
 * Created by yugj on 18/7/3 14:59.
 */
@RestController
@RequestMapping("/consul")
public class HellClientController {

    @Autowired
    private HellStub hellStub;

    @RequestMapping("/hell-client")
    @ResponseBody
    public String hellClient(String hell) {

        HellReq hellReq = new HellReq();

        if (hell == null) {
            hellReq.setHellReq("yugj test");
        } else {
            hellReq.setHellReq(hell);
        }

        HellResp resp = hellStub.hell(hellReq);

        return "feign client resp : " + resp.getHellResp();

    }


}
