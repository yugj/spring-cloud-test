package indi.yugj.test.springcloud.rabbitmq.sleuth;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.sleuth.TraceKeys;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.autoconfig.TraceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.regex.Pattern;

/**
 * @author yugj
 * @date 2019/1/25 下午3:10.
 */
@Configuration
@EnableAspectJAutoProxy
@ConditionalOnProperty(value = "spring.sleuth.rabbitmq.enabled", matchIfMissing = true)
@AutoConfigureAfter(TraceAutoConfiguration.class)
@EnableConfigurationProperties(SleuthRabbitListenerProperties.class)
public class TraceRabbitListenerAutoConfiguration {

    @ConditionalOnClass(name = "org.aspectj.lang.ProceedingJoinPoint")
    @Bean
    public TraceRabbitListenerAspect traceRabbitListenerAspect(Tracer tracer, TraceKeys traceKeys,
                                                       SleuthRabbitListenerProperties sleuthRabbitListenerProperties) {
        return new TraceRabbitListenerAspect(tracer, traceKeys, Pattern.compile(sleuthRabbitListenerProperties.getSkipPattern()));
    }


}
