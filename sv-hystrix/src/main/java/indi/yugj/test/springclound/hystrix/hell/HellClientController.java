package indi.yugj.test.springclound.hystrix.hell;

import indi.yugj.test.springclound.hystrix.feign.HellStub;
import indi.yugj.test.springclound.hystrix.feign.HellStub2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:测试类,触发入口
 * Created by yugj on 18/7/3 14:59.
 */
@RestController
@RequestMapping("/hystrix")
public class HellClientController {

    @Autowired
    private HellStub hellStub;
    @Autowired
    private HellStub2 hellStub2;

    @RequestMapping("/hell-client")
    @ResponseBody
//    @HystrixCommand
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


    @RequestMapping("/hell-client2")
    @ResponseBody
//    @HystrixCommand
    public String hellClient2(String hell) {

        HellReq hellReq = new HellReq();

        if (hell == null) {
            hellReq.setHellReq("yugj test");
        } else {
            hellReq.setHellReq(hell);
        }

        HellResp resp = hellStub2.hell2(hellReq);

        return "feign client resp : " + resp.getHellResp();

    }

}
