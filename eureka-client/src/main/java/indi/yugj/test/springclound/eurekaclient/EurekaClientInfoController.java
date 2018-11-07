package indi.yugj.test.springclound.eurekaclient;

import com.alibaba.fastjson.JSON;
import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yugj
 * @date 18/11/7 22:06.
 */
@RestController
@RequestMapping("/eureka-client")
public class EurekaClientInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EurekaClientInfoController.class);

    @Autowired
    private EurekaClientService clientService;

    @RequestMapping("/info")
    public String clientInfo() {

        DiscoveryClient client = clientService.get();
        List<InstanceInfo> instances =  client.getInstancesById("192.168.1.3:9011");


        LOGGER.info("instances:{}", JSON.toJSONString(instances));

        return "success";

    }

    @RequestMapping("/changeStatus")
    public String changeStatus(String status) {

        InstanceInfo.InstanceStatus instanceStatus = InstanceInfo.InstanceStatus.valueOf(status);

        ApplicationInfoManager.getInstance().setInstanceStatus(instanceStatus);

        return "ok";

    }



}
