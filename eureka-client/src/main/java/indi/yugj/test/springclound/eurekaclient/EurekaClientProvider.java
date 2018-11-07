package indi.yugj.test.springclound.eurekaclient;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.DiscoveryManager;

/**
 * @author yugj
 * @date 18/11/7 22:09.
 */
public class EurekaClientProvider {

    private DiscoveryClient eurekaClient;

    public synchronized DiscoveryClient get() {
        if (eurekaClient == null) {
            eurekaClient = DiscoveryManager.getInstance().getDiscoveryClient();
        }
        return eurekaClient;
    }
}
