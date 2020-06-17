package cn.yugj.logback;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yugj
 * @date 2020-06-15 15:55.
 */
@ConfigurationProperties(prefix = "sys.log.whitefilter")
@Component
public class WhiteFilterProperties {

    private boolean enabled = true;

    private Map<String, String> whitelist = new HashMap<>();


    public Map<String, String> getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(Map<String, String> whitelist) {
        this.whitelist = whitelist;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
