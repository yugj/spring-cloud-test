package cn.yugj.test.nacos.provider;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Service;

/**
 * @author yugj
 * @date 2020/7/16 2:21 下午.
 */
@Service
public class NacosAfterStoppedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Value("${sys.useNacosAfterStoppedEvent:false}")
    private boolean useNacosAfterStoppedEvent;
    @Value("${spring.application.name}")
    private String appName;
    @Value("${spring.cloud.nacos.discovery.group}")
    private String group;

    @Value("${spring.cloud.client.ip-address}")
    private String ip;
    @Value("${server.port}")
    private Integer port;

    @Value("${ribbon.ServerListRefreshInterval:10000}")
    private Integer ribbonRefreshInterval;
    @Value("${sys.nacos.otherMessTimeInSeconds:5}")
    private Integer otherMessTimeInSeconds;

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    private static final Logger log = LoggerFactory.getLogger(NacosAfterStoppedEventListener.class);


    @Override
    public void onApplicationEvent(ContextClosedEvent event) {

        ApplicationContext app = event.getApplicationContext();
        if (!app.equals(appContext)) {
            return;
        }

        log.info("receive context closed event, prepare to deregister nacos instance");

        if (!useNacosAfterStoppedEvent) {
            log.info("useNacosAfterStoppedEvent :{}", useNacosAfterStoppedEvent);
            return;
        }

        try {
            nacosDiscoveryProperties.namingServiceInstance().deregisterInstance(appName, group, ip, port);
        } catch (Exception e) {
            log.warn("deregister current instance failed appName :{}, group :{}, ip :{}, port :{}"
                    , appName, group, ip, port, e);
        }

        try {
            Long toWaitTime = getSysWaitTimeInMills();
            log.info("instance offline success,system will wait {} milliseconds before shutdown", toWaitTime);
            Thread.sleep(toWaitTime);
        } catch (InterruptedException e) {
            log.warn("sys interrupted", e);
        }

        log.info("nacos after stopped event finished, wait other system event stop");
    }

    private Long getSysWaitTimeInMills() {
        return this.ribbonRefreshInterval + otherMessTimeInSeconds * 1000L;
    }
}
