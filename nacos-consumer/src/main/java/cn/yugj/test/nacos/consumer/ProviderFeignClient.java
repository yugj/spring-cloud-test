package cn.yugj.test.nacos.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yugj
 * @date 2020/6/29 5:52 下午.
 */
@FeignClient(name = "nacos-provider")
@Component
public interface ProviderFeignClient {

    @GetMapping(value = "/echo/{string}")
    String echo(@PathVariable String string);
}
