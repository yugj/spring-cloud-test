package cn.yugj.test.zuul.sentinel.ratelimit;

import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.fallback.DefaultBlockFallbackProvider;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.fallback.ZuulBlockFallbackManager;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulErrorFilter;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulPostFilter;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulPreFilter;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.zookeeper.ZookeeperDataSource;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * @author yugj
 * @date 2021/5/30 23:05.
 */
@Configuration
public class ZkRateLimitConfiguration {

    @Value("${sentinel.repository.zookeeper.nodes}")
    private String zkNodes;


    public static final String RULE_ROOT_PATH = "/sentinel/sentinel_rule_config";

    @Bean
    public ZuulFilter sentinelZuulPreFilter() {
        // We can also provider the filter order in the constructor.
        return new SentinelZuulPreFilter();
    }

    @Bean
    public ZuulFilter sentinelZuulPostFilter() {
        return new SentinelZuulPostFilter();
    }

    @Bean
    public ZuulFilter sentinelZuulErrorFilter() {
        return new SentinelZuulErrorFilter();
    }


    @PostConstruct
    public void doInit() throws Exception {

        initGatewayRules();

        //默认 fallback provider不打印日志，另外返回格式不是业务需要，重写下
        ZuulBlockFallbackManager.registerProvider(new DefaultBlockFallbackProvider());
    }


    private void initGatewayRules() {

        ReadableDataSource<String, Set<GatewayFlowRule>> flowRuleDataSource =
                new ZookeeperDataSource<>(zkNodes, RULE_ROOT_PATH,
                        buildFlowConfigParser());

        GatewayRuleManager.register2Property(flowRuleDataSource.getProperty());
    }

    private Converter<String, Set<GatewayFlowRule>> buildFlowConfigParser() {
        return source -> JSON.parseObject(source, new TypeReference<Set<GatewayFlowRule>>() {});
    }
}
