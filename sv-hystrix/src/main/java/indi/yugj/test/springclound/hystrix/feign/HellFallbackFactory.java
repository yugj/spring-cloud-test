package indi.yugj.test.springclound.hystrix.feign;

import feign.hystrix.FallbackFactory;
import indi.yugj.test.springclound.hystrix.hell.schema.HellReq;
import indi.yugj.test.springclound.hystrix.hell.schema.HellResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Description:
 * Created by yugj on 18/7/3 15:23.
 */
@Component
public class HellFallbackFactory implements FallbackFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(HellFallbackFactory.class);

    /**
     * 一般定义通用的fallback处理,这边测试功能,临时随意定义
     * @param throwable
     * @return
     */
    @Override
    public HellStub create(Throwable throwable) {

       return new HellStub() {


           @Override
           public HellResp hell(@RequestBody HellReq req) {
               HellResp resp = new HellResp();
               resp.setHellResp("fallback,reason :" + throwable.getMessage());

               //log 在create方法进入打印启动会报错,临时看到这样解决,不清楚具体原因
               HellFallbackFactory.LOGGER.warn("hell factory fallback :" + throwable.getMessage(), throwable);
               return resp;
           }

           @Override
           public HellResp good(@RequestBody HellReq req) {
               return null;
           }
       };
    }

}
