package cn.yugj.test.nacos.provider;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yugj
 * @date 2020/6/29 4:35 下午.
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class NacosConfProperties {

    private String sop;

    public String getSop() {
        return sop;
    }

    public void setSop(String sop) {
        this.sop = sop;
    }
}
