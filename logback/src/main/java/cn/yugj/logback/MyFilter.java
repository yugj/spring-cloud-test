package cn.yugj.logback;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @author yugj
 * @date 2020-06-15 15:00.
 */
public class MyFilter extends Filter<ILoggingEvent> {



    @Override
    public FilterReply decide(ILoggingEvent event) {

        //info 以上级别 不过滤
        if (event.getLevel().levelInt > Level.INFO_INT) {
            return FilterReply.ACCEPT;
        }

        //info 及以下级别 根据条件判断是否允许打印
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        Object obj = requestAttributes.getAttribute("shouldlog",0);

        if (obj.toString().equals("xxx")) {
            return FilterReply.ACCEPT;
        }

        return FilterReply.DENY;
    }
}
