package indi.yugj.springclound.zipkin.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * Created by yugj on 18/5/31 09:55.
 */
@RequestMapping("/hell")
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/hell")
    public String hell() {
        return "hell" + System.currentTimeMillis();
    }
}
