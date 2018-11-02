package indi.yugj.test.springclound.ribbon;

import indi.yugj.test.springclound.ribbon.schema.HellReq;
import indi.yugj.test.springclound.ribbon.schema.HellResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yugj
 * @date 18/11/1 20:47.
 */
@Controller
@RequestMapping("/ribbon")
public class HellController {

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

        try {
            HellResp resp = hellStub.hell(hellReq);
            System.out.println("hell ->> success:" + resp.getHellResp());
            return "feign client resp : " + resp.getHellResp();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }



    }
}
