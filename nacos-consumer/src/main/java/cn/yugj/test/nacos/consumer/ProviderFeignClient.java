package cn.yugj.test.nacos.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yugj
 * @date 2020/6/29 5:52 下午.
 */
public interface ProviderFeignClient {

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string);
}
