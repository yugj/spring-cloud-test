package cn.yugj.test.nacos.consumer;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yugj
 * @date 2020/6/30 11:26 上午.
 */
@Configuration
public class NacosConsumerConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new NacosWeightRandomRule();
    }

}
