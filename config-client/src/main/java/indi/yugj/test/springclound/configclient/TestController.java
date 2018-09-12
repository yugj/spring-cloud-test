package indi.yugj.test.springclound.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yugj
 * @date 18/9/10 09:48.
 */
@Controller
@RequestMapping("/config-client")
@RefreshScope
public class TestController {

    @Autowired
    private Environment env;

    @RequestMapping("/hell1")
    @ResponseBody
    public String hell1() {

//        String test = env.get("test.req");
        String test = env.getProperty("test.is.checkRules.test.req");
        return "hell-1";
    }
}
