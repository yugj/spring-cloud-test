package indi.yugj.test.springclound.configclient;

import com.google.common.collect.Maps;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Description: access 配置文件
 * Created by yugj on 17/12/28 09:58.
 */
@Component
@RefreshScope
@ConfigurationProperties(prefix = "test.is")
public class AccessRulesConfig {

    private Map<String, String> checkRules = Maps.newHashMap();

    public String get(String key) {
        return checkRules.get(key);
    }

    public Map<String, String> getCheckRules() {
        return checkRules;
    }

    public void setCheckRules(Map<String, String> checkRules) {
        this.checkRules = checkRules;
    }
}
