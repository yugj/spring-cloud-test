package indi.yugj.test.springcloud.zuul.ratelimit;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimitUtils;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yugj
 * @date 2019/8/5 上午10:54.
 */
public enum CustomRateLimitType {


    /**
     * 基于用户IP限流策略
     */
    USERIP {

        @Override
        public boolean apply(HttpServletRequest request, Route route, RateLimitUtils rateLimitUtils, String matcher) {
            return matcher.equals(rateLimitUtils.getRemoteAddress(request));
        }

        @Override
        public String key(HttpServletRequest request, Route route, String matcher) {
            return getRemoteHost(request);
        }
    },

    /**
     * 基于用户ID限流策略
     */
    USERID {

        @Override
        public boolean apply(HttpServletRequest request, Route route, RateLimitUtils rateLimitUtils,/*not null*/ String matcher) {
            return request.getHeader("xx-userid").equalsIgnoreCase(matcher);
        }

        @Override
        public String key(HttpServletRequest request, Route route, String matcher) {
            return request.getHeader("xx-userid");
        }
    },;

    private static final String UNKNOWN = "unknown";

    /**
     * 获取ip
     *
     * @param request
     * @return
     */
    public static String getRemoteHost(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Cdn-Src-Ip");
        }
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        ip = "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;

        return ip.split(",")[0].trim();
    }

    public abstract boolean apply(HttpServletRequest request, Route route,
                                  RateLimitUtils rateLimitUtils, String matcher);

    public abstract String key(HttpServletRequest request, Route route,
                                String matcher);

}
