package indi.yugj.test.springcloud.restsv.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author yugj
 * @date 2018/12/14 上午10:15.
 */
@Component
public class JobHelper implements InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(JobHelper.class);

    @Autowired
    private TraceableExecutorService executorService;

    public static ExecutorService EXECUTOR_SERVICE;

    public static <T> Future<T> submit(Callable<T> task) {

        log.info("job submit");

        if (EXECUTOR_SERVICE.isShutdown()) {
            log.warn("thread pool is shutdown,job canceled");
            return null;
        }

        return EXECUTOR_SERVICE.submit(task);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        EXECUTOR_SERVICE = executorService;
    }
}
