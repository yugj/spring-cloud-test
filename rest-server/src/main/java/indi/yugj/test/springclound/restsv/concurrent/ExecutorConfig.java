package indi.yugj.test.springclound.restsv.concurrent;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yugj
 * @date 2018/12/14 上午10:12.
 */
@Configuration
@EnableAutoConfiguration
@EnableAsync
public class ExecutorConfig extends AsyncConfigurerSupport {


    @Autowired
    private BeanFactory beanFactory;

    @Override
    public TraceableExecutorService getAsyncExecutor() {
        ExecutorService executorService = new ThreadPoolExecutor(10, 20,
                60L, TimeUnit.SECONDS, new SynchronousQueue<>());
        return new TraceableExecutorService(this.beanFactory, executorService);
    }

    @Bean
    public TraceableExecutorService getSysExecutorService(){
        return getAsyncExecutor();
    }

}
