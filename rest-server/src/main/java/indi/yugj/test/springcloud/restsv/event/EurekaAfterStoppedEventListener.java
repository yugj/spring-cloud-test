package indi.yugj.test.springcloud.restsv.event;

import com.netflix.discovery.DiscoveryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Service;

/**
 * 关闭之前先在eureka server注销
 * @author yugj
 * @date 2018/12/6 下午2:23.
 */
@Service
public class EurekaAfterStoppedEventListener implements ApplicationListener<ContextClosedEvent> {

    private static final Logger log = LoggerFactory.getLogger(EurekaAfterStoppedEventListener.class);

    @Value("${sys.eureka.shuntDownWaitSeconds:1}")
    private Integer shuntDownWaitSeconds;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {

        log.info("context closed event");
        log.info("offline instance...,sys will wait {} seconds before shutdown", shuntDownWaitSeconds);

        DiscoveryManager.getInstance().shutdownComponent();

        try {
            Thread.sleep(shuntDownWaitSeconds * 1000L);

        } catch (InterruptedException e) {
            log.warn(e.getMessage());
        }

        log.info("add shutdown hook");

        Runtime.getRuntime().addShutdownHook(new ShutdownHook(Thread.currentThread()));

        log.info("waiting other event close");


    }
}
