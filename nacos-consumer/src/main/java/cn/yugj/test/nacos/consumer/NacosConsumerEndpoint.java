package cn.yugj.test.nacos.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yugj
 * @date 2020/6/29 5:51 下午.
 */
@RestController
public class NacosConsumerEndpoint {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProviderFeignClient providerFeignClient;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/echo/app-name")
    public String echoAppName() {

        String feignResp = providerFeignClient.echo("feign test");
        System.out.println("feign test :" + feignResp);

        //Access through the combination of LoadBalanceClient and RestTemplate
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String path = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);

        System.out.println("request path:" + path);
        String restResp = restTemplate.getForObject(path, String.class);
        System.out.println("resp test:" + restResp);

        return restResp;
    }
}
