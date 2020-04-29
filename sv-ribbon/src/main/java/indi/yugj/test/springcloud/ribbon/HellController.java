package indi.yugj.test.springcloud.ribbon;

import indi.yugj.test.springcloud.ribbon.schema.HellReq;
import indi.yugj.test.springcloud.ribbon.schema.HellResp;
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
    @Autowired
    private JustRibbonStub justRibbonStub;

    @RequestMapping("/hell-client")
    @ResponseBody
    public String hellClient(String hell) {

        HellReq hellReq = new HellReq();

        if (hell == null) {
//            hellReq.setHellReq("yugj test");
        } else {
            hellReq.setHellReq(hell);
        }
        HellResp resp = hellStub.hell(hellReq);
//        Integer end = Integer.valueOf(hell);
//        for (int i = 0; i < end; i++) {
//
//            try {
//                Thread.sleep(1000L);
//
//                HellResp resp = hellStub.hell(hellReq);
//                System.out.println("hell ----------------------------------------------------->> success:" + resp.getHellResp());
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }

        return "hell";

    }

    @RequestMapping("/just-rb")
    @ResponseBody
    public String justRb(String hell) {

        HellReq hellReq = new HellReq();

        if (hell == null) {
            hellReq.setHellReq("yugj test");
        } else {
            hellReq.setHellReq(hell);
        }

        HellResp resp = justRibbonStub.hell(hellReq);
        return "just-ribbon works fine," + resp.getHellResp();
    }
}

