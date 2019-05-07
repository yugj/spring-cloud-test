package indi.yugj.test.springcloud.hystrix.sleuth;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yugj
 * @date 2019/1/25 下午3:11.
 */
@ConfigurationProperties("spring.sleuth.rabbitmq")
public class SleuthRabbitListenerProperties {

    /**
     * Enable tracing for {@link org.springframework.scheduling.annotation.Scheduled}.
     */
    private boolean enabled = true;

    /**
     * Pattern for the fully qualified name of a class that should be skipped.
     */
    private String skipPattern = "";

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSkipPattern() {
        return this.skipPattern;
    }

    public void setSkipPattern(String skipPattern) {
        this.skipPattern = skipPattern;
    }
}
