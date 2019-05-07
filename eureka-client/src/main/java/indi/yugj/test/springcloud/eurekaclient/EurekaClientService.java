package indi.yugj.test.springcloud.eurekaclient;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

/**
 * @author yugj
 * @date 18/11/7 22:35.
 */
@Service
public class EurekaClientService {

    EurekaClientProvider eurekaClientProvider = new EurekaClientProvider();

    public DiscoveryClient get() {
        return eurekaClientProvider.get();
    }
}
