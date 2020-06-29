package cn.yugj.test.nacos.provider;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yugj
 * @date 2020/6/29 4:35 下午.
 */
@Component
@ConfigurationProperties(prefix = "common")
public class NacosExtProperties {

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
