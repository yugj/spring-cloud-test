package cn.yugj.test.sentinel.mvc.ratelimit;

import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.zookeeper.ZookeeperDataSource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author yugj
 * @date 2019/8/12 下午7:41.
 */
@Configuration
public class RateLimitConfiguration {

    private String channel = "sentinel.rules.flow.channel";
    private String ruleKey = "sentinel.rules.flow.ruleKey";

    @PostConstruct
    public void doInit() {

//        RedisConnectionConfig config = RedisConnectionConfig.builder()
//                .withHost("localhost")
//                .withPort(6379)
//                .build();

//        Converter<String, List<FlowRule>> flowConfigParser = buildFlowConfigParser();

//        ReadableDataSource<String, List<FlowRule>> redisDataSource = new RedisDataSource<List<FlowRule>>(config, ruleKey, channel, flowConfigParser);

//        FlowRuleManager.register2Property(redisDataSource.getProperty());

        loadRules();

    }

    private void loadRules() {

        final String remoteAddress = "127.0.0.1:2181";
        final String path = "/Sentinel-Demo/SYSTEM-CODE-DEMO-FLOW";

        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new ZookeeperDataSource<>(remoteAddress, path,
                buildFlowConfigParser());
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());


    }

    private Converter<String, List<FlowRule>> buildFlowConfigParser() {
        return source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {});
    }
}
