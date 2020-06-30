package cn.yugj.test.nacos.consumer;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 使用nacos 基于权重负载均衡 代替默认 ZoneAvoidanceRule
 *
 * @author yugj
 * @date 2020/6/30 9:49 上午.
 */
public class NacosWeightRandomRule extends ZoneAvoidanceRule {

    @Autowired
    private NacosDiscoveryProperties discoveryProperties;
    private static final Logger log = LoggerFactory.getLogger(NacosWeightRandomRule.class);


    @Override
    public Server choose(Object key) {

        DynamicServerListLoadBalancer loadBalancer = (DynamicServerListLoadBalancer) getLoadBalancer();

        String name = loadBalancer.getName();

        try {

            Instance instance = discoveryProperties
                    .namingServiceInstance()
                    .selectOneHealthyInstance(name, discoveryProperties.getGroup());

//            log.info("选中的instance = {}", instance.getPort());

            /*
             * instance转server的逻辑参考自：
             * org.springframework.cloud.alibaba.nacos.ribbon.NacosServerList.instancesToServerList
             */
            return new NacosServer(instance);
        } catch (NacosException e) {
            log.warn("nacos weight rule error", e);
            return super.choose(key);
        }
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }
}