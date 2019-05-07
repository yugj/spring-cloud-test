package indi.yugj.test.springcloud.restsv.hell;

import com.netflix.discovery.DiscoveryManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yugj
 * @date 18/12/4 13:09.
 */
@RestController
public class EurekaManageController {

    @RequestMapping("/offline")
    public String offline() {
        DiscoveryManager.getInstance().shutdownComponent();
        return "success";
    }
}
