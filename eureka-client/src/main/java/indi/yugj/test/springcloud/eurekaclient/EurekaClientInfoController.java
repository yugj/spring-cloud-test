package indi.yugj.test.springcloud.eurekaclient;

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
 * DiscoveryClient refreshRegistry 默认包访问权限
 * 意味着刷新配置不暴露
 * 可能由于某些原因需要保护现有轮询机制?
 * https://github.com/spring-cloud/spring-cloud-netflix/issues/1682#issuecomment-278994223
 * There is no way to force a client to poll the Eureka server. What @Aloren is suggesting is that you adjust the interval at which the client fetches the registry information from the server so it happens quicker/more often.
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
