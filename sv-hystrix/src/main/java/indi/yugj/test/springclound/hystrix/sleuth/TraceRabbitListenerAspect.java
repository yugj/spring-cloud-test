package indi.yugj.test.springclound.hystrix.sleuth;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.TraceKeys;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.util.SpanNameUtil;

import java.util.regex.Pattern;

/**
 * @author yugj
 * @date 2019/1/25 下午2:59.
 */
@Aspect
public class TraceRabbitListenerAspect {

    private static final String RABBIT_LISTENER_COMPONENT = "rabbitmq";

    private final Tracer tracer;
    private final TraceKeys traceKeys;
    private final Pattern skipPattern;

    public TraceRabbitListenerAspect(Tracer tracer, TraceKeys traceKeys, Pattern skipPattern) {
        this.tracer = tracer;
        this.traceKeys = traceKeys;
        this.skipPattern = skipPattern;
    }

    @Around("@annotation(org.springframework.amqp.rabbit.annotation.RabbitListener)")
    public Object traceBackgroundThread(final ProceedingJoinPoint pjp) throws Throwable {

        if (this.skipPattern.matcher(pjp.getTarget().getClass().getName()).matches()) {
            return pjp.proceed();
        }

        String spanName = SpanNameUtil.toLowerHyphen(pjp.getSignature().getName());
        Span span = this.tracer.createSpan(spanName);
        this.tracer.addTag(Span.SPAN_LOCAL_COMPONENT_TAG_NAME, RABBIT_LISTENER_COMPONENT);
        this.tracer.addTag(this.traceKeys.getAsync().getPrefix() +
                this.traceKeys.getAsync().getClassNameKey(), pjp.getTarget().getClass().getSimpleName());
        this.tracer.addTag(this.traceKeys.getAsync().getPrefix() +
                this.traceKeys.getAsync().getMethodNameKey(), pjp.getSignature().getName());
        try {
            return pjp.proceed();
        } finally {

            if (this.tracer.isTracing()) {
                this.tracer.close(span);
            }
        }
    }
}
