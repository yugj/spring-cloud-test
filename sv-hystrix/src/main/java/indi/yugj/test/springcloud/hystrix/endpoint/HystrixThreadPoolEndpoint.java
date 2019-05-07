package indi.yugj.test.springcloud.hystrix.endpoint;

import com.netflix.hystrix.HystrixThreadPoolMetrics;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yugj
 * @date 19/5/5 22:17.
 */
@RestController
@RequestMapping(path = "/sys/hystrix")
@ManagedResource(description = "hystrix Endpoint")
public class HystrixThreadPoolEndpoint {

    @GetMapping(value = "/threads")
    public List<HystrixThreadStats> threadStats() {

        return HystrixThreadPoolMetrics.getInstances().stream().map((m) -> {

            final HystrixThreadStats stats = new HystrixThreadStats();
            stats.poolName = m.getThreadPoolKey().name();
            stats.cumulativeExecuted = m.getCumulativeCountThreadsExecuted();
            stats.currentActiveCount = m.getCurrentActiveCount().intValue();
            stats.currentCompletedCount = m.getCurrentCompletedTaskCount().intValue();
            stats.currentCorePoolSize = m.getCurrentCorePoolSize().intValue();
            stats.currentLargestPoolSize = m.getCurrentLargestPoolSize().intValue();
            stats.currentMaxPoolSize = m.getCurrentMaximumPoolSize().intValue();
            stats.currentPoolSize = m.getCurrentPoolSize().intValue();
            stats.currentQueueSize = m.getCurrentQueueSize().intValue();
            stats.currentTaskCount = m.getCurrentTaskCount().intValue();

            return stats;
        }).collect(Collectors.toList());
    }

    class HystrixThreadStats {
        private String poolName;
        private Long cumulativeExecuted;
        private Integer currentActiveCount;
        private Integer currentCompletedCount;
        private Integer currentCorePoolSize;
        private Integer currentLargestPoolSize;
        private Integer currentMaxPoolSize;
        private Integer currentPoolSize;
        private Integer currentQueueSize;
        private Integer currentTaskCount;

        public String getPoolName() {
            return poolName;
        }

        public void setPoolName(String poolName) {
            this.poolName = poolName;
        }

        public Long getCumulativeExecuted() {
            return cumulativeExecuted;
        }

        public void setCumulativeExecuted(Long cumulativeExecuted) {
            this.cumulativeExecuted = cumulativeExecuted;
        }

        public Integer getCurrentActiveCount() {
            return currentActiveCount;
        }

        public void setCurrentActiveCount(Integer currentActiveCount) {
            this.currentActiveCount = currentActiveCount;
        }

        public Integer getCurrentCompletedCount() {
            return currentCompletedCount;
        }

        public void setCurrentCompletedCount(Integer currentCompletedCount) {
            this.currentCompletedCount = currentCompletedCount;
        }

        public Integer getCurrentCorePoolSize() {
            return currentCorePoolSize;
        }

        public void setCurrentCorePoolSize(Integer currentCorePoolSize) {
            this.currentCorePoolSize = currentCorePoolSize;
        }

        public Integer getCurrentLargestPoolSize() {
            return currentLargestPoolSize;
        }

        public void setCurrentLargestPoolSize(Integer currentLargestPoolSize) {
            this.currentLargestPoolSize = currentLargestPoolSize;
        }

        public Integer getCurrentMaxPoolSize() {
            return currentMaxPoolSize;
        }

        public void setCurrentMaxPoolSize(Integer currentMaxPoolSize) {
            this.currentMaxPoolSize = currentMaxPoolSize;
        }

        public Integer getCurrentPoolSize() {
            return currentPoolSize;
        }

        public void setCurrentPoolSize(Integer currentPoolSize) {
            this.currentPoolSize = currentPoolSize;
        }

        public Integer getCurrentQueueSize() {
            return currentQueueSize;
        }

        public void setCurrentQueueSize(Integer currentQueueSize) {
            this.currentQueueSize = currentQueueSize;
        }

        public Integer getCurrentTaskCount() {
            return currentTaskCount;
        }

        public void setCurrentTaskCount(Integer currentTaskCount) {
            this.currentTaskCount = currentTaskCount;
        }
    }

}
