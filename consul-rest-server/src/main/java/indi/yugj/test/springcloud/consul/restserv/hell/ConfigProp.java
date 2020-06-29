package indi.yugj.test.springcloud.consul.restserv.hell;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yugj
 * @date 2020/6/29 10:52 上午.
 */
@Component
@ConfigurationProperties(prefix = "test")
public class ConfigProp {


    private String hell;

    public String getHell() {
        return hell;
    }

    public void setHell(String hell) {
        this.hell = hell;
    }
}
