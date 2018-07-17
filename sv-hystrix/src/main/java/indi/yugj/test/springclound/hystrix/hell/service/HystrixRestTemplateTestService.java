package indi.yugj.test.springclound.hystrix.hell.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import indi.yugj.test.springclound.hystrix.hell.schema.HellReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Description:rest template using hystrix test
 * Created by yugj on 18/7/17 15:18.
 */
@Service
public class HystrixRestTemplateTestService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * commandKey定义为了定制配置hystrix
     * @param hell
     * @return
     */
    @HystrixCommand(commandKey = "hystrix-rest",fallbackMethod = "fallback")
    public String hell(String hell) {

        String server = "http://localhost:9006/rest-sv/hell";

        HellReq req = new HellReq();
        req.setHellReq(hell);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("key1", "values");
        requestHeaders.add("key2", "ddd");
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(req, requestHeaders);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(server, HttpMethod.POST, requestEntity, String.class);

        return response.getBody();
    }

    /**
     * 方法定义和主方法一致,即使参数不使用
     * fallback data
     * @return msg
     */
    private String fallback(String hell) {

        System.out.println("hystrix-rest-template-fallback");
        return "hystrix-rest-template-fallback";
    }

}
