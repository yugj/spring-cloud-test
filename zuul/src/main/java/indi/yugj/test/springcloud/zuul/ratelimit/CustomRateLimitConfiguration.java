package indi.yugj.test.springcloud.zuul.ratelimit;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimitKeyGenerator;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimitUtils;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.support.DefaultRateLimitKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author yugj
 * @date 2019/8/5 上午10:30.
 */
@Configuration
public class CustomRateLimitConfiguration {

    @Autowired
    private CustomRateLimitProperties customRateLimitProperties;

    @Bean
    public RateLimitKeyGenerator ratelimitKeyGenerator(RateLimitProperties properties, RateLimitUtils rateLimitUtils) {

        return new DefaultRateLimitKeyGenerator(properties, rateLimitUtils) {

            @Override
            public String key(HttpServletRequest request, Route route, RateLimitProperties.Policy policy) {

                String supperKey  =  super.key(request, route, policy) + ":" + request.getMethod();

                List<String> customRules =  customRateLimitProperties.getCustomRules();
                String customKey = getCustomRuleKey(customRules, request, route, policy, null);

                return supperKey + customKey;

            }
        };
    }

    private String getCustomRuleKey(List<String> customRules,
                                    HttpServletRequest request, Route route,
                                    RateLimitProperties.Policy policy,
                                    String matcher) {

        if (CollectionUtils.isEmpty(customRules)) {
            return org.apache.commons.lang.StringUtils.EMPTY;
        }

        final StringJoiner joiner = new StringJoiner(":");
        for (String customRule : customRules) {
            CustomRateLimitType customRateLimitType = CustomRateLimitType.valueOf(customRule.toUpperCase());
            joiner.add(customRateLimitType.key(request, route, matcher));
        }

        return joiner.toString();

    }


}
