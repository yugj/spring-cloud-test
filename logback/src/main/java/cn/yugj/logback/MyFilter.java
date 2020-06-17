package cn.yugj.logback;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import net.logstash.logback.encoder.org.apache.commons.lang.BooleanUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yugj
 * @date 2020-06-15 15:00.
 */
@Component
public class MyFilter extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent event) {

        //info 以上级别 不过滤
        if (event.getLevel().levelInt > Level.INFO_INT) {
            return FilterReply.ACCEPT;
        }

        Environment env = null;

        try {
            env = SpringBeanUtil.get(Environment.class);
        } catch (Exception e) {
            return FilterReply.ACCEPT;
        }

        if (env == null
                || !BooleanUtils.toBoolean(env.getProperty(WhiteFilterConstants.SYS_LOG_WHITEFILTER_ENABLED))) {
            return FilterReply.ACCEPT;
        }

        HttpServletRequest request = null;
        try {
            request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        } catch (Exception e) {
            return FilterReply.ACCEPT;
        }

        if (request == null) {
            return FilterReply.ACCEPT;
        }

        Object shouldLog = request.getHeader(WhiteFilterConstants.SHOULD_LOG_KEY);
        if (shouldLog == null) {
            return FilterReply.DENY;
        }

        if (WhiteFilterConstants.SHOULD_LOG_VAL.equals(shouldLog.toString())) {
            return FilterReply.ACCEPT;
        }

        return FilterReply.DENY;
    }
}
