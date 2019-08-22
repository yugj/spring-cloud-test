package indi.yugj.test.springcloud.hystrix.config;

import com.netflix.client.config.DefaultClientConfigImpl;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.commons.httpclient.ApacheHttpClientConnectionManagerFactory;
import org.springframework.cloud.commons.httpclient.ApacheHttpClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author yugj
 * @date 2019/8/22 下午4:08.
 */
@Configuration
public class HttpPoolConfiguration {

    private final Timer connectionManagerTimer = new Timer(
            "RibbonApacheHttpClientConfiguration.connectionManagerTimer", true);
    private CloseableHttpClient httpClient;

    @Autowired(required = false)
    private RegistryBuilder registryBuilder;


    @Bean
    public HttpClientConnectionManager httpClientConnectionManager(
            ApacheHttpClientConnectionManagerFactory connectionManagerFactory) {

        Integer maxTotalConnections = 50;
        Integer maxConnectionsPerHost = 50;
        Integer timerRepeat = 30000;
        Long timeToLive = DefaultClientConfigImpl.DEFAULT_POOL_KEEP_ALIVE_TIME;

        TimeUnit ttlUnit = DefaultClientConfigImpl.DEFAULT_POOL_KEEP_ALIVE_TIME_UNITS;

        final HttpClientConnectionManager connectionManager = connectionManagerFactory
                .newConnectionManager(false, maxTotalConnections,
                        maxConnectionsPerHost, timeToLive, ttlUnit, registryBuilder);
        this.connectionManagerTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                connectionManager.closeExpiredConnections();
            }
        }, 30000, timerRepeat);
        return connectionManager;
    }

    @Bean
    public CloseableHttpClient httpClient(ApacheHttpClientFactory httpClientFactory,
                                          HttpClientConnectionManager connectionManager) {

        Boolean followRedirects =
                DefaultClientConfigImpl.DEFAULT_FOLLOW_REDIRECTS;

        Integer connectTimeout =
                DefaultClientConfigImpl.DEFAULT_CONNECT_TIMEOUT;

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setConnectTimeout(connectTimeout)
                .setRedirectsEnabled(followRedirects).build();

        this.httpClient = httpClientFactory.createBuilder().
                setDefaultRequestConfig(defaultRequestConfig).
                setConnectionManager(connectionManager).build();
        return httpClient;
    }

}
