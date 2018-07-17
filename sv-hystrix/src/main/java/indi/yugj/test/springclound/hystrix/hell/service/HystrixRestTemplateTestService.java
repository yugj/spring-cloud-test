package indi.yugj.test.springclound.hystrix.hell.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import indi.yugj.test.springclound.hystrix.hell.schema.HellReq;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Description:rest template using hystrix test
 * Created by yugj on 18/7/17 15:18.
 */
@Service
public class HystrixRestTemplateTestService {

    /**
     * commandKey定义为了定制配置hystrix
     * @param hell
     * @return
     */
    @HystrixCommand(commandKey = "hystrix-rest",fallbackMethod = "fallback")
    public String hell(String hell) {

        URI uri = URI.create("http://localhost:9006/rest-sv/hell");

        HellReq req = new HellReq();
        req.setHellReq(hell);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(uri, req, String.class);
    }

    /**
     * 方法定义和主方法一致,即使参数不使用
     * fallback data
     * @return msg
     */
    public String fallback(String hell) {

        System.out.println("hystrix-rest-template-fallback");
        return "hystrix-rest-template-fallback";
    }

}
