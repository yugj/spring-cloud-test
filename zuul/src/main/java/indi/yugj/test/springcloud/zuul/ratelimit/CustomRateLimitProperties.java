package indi.yugj.test.springcloud.zuul.ratelimit;

import com.google.common.collect.Lists;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yugj
 * @date 2019/8/5 上午10:43.
 */
@Component
@RefreshScope
@ConfigurationProperties(RateLimitProperties.PREFIX)
public class CustomRateLimitProperties {

    private List<String> customRules = Lists.newArrayList();


    public List<String> getCustomRules() {
        return customRules;
    }

    public void setCustomRules(List<String> customRules) {
        this.customRules = customRules;
    }
}
