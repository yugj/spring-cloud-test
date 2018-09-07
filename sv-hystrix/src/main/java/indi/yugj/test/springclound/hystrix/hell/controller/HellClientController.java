package indi.yugj.test.springclound.hystrix.hell.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import indi.yugj.test.springclound.hystrix.feign.HellStub;
import indi.yugj.test.springclound.hystrix.feign.HellStub2;
import indi.yugj.test.springclound.hystrix.feign.HellStub3;
import indi.yugj.test.springclound.hystrix.hell.schema.HellReq;
import indi.yugj.test.springclound.hystrix.hell.schema.HellResp;
import indi.yugj.test.springclound.hystrix.hell.service.HystrixRestTemplateTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description:测试类,触发入口
 * Created by yugj on 18/7/3 14:59.
 */
@RestController
@RequestMapping("/hystrix")
public class HellClientController {

    @Autowired
    private HellStub hellStub;
    @Autowired
    private HellStub2 hellStub2;
    @Autowired
    private HellStub3 hellStub3;
    @Autowired
    private HystrixRestTemplateTestService hellService;

    @RequestMapping("/hell-client")
    @ResponseBody
    public String hellClient(String hell) {

        HellReq hellReq = new HellReq();

        if (hell == null) {
            hellReq.setHellReq("yugj test");
        } else {
            hellReq.setHellReq(hell);
        }

        HellResp resp = hellStub.hell(hellReq);

        return "feign client resp : " + resp.getHellResp();

    }


    @RequestMapping("/hell-client2")
    @ResponseBody
    public String hellClient2(String hell) {

        HellReq hellReq = new HellReq();

        if (hell == null) {
            hellReq.setHellReq("yugj test");
        } else {
            hellReq.setHellReq(hell);
        }

        HellResp resp = hellStub2.hell2(hellReq);

        return "feign client resp : " + resp.getHellResp();

    }


    @RequestMapping("/hell-client3")
    @ResponseBody
    public String hellClient3(String hell) {

        String rs = hellService.hell(hell);

        return "rest template resp : " + rs;

    }

    @RequestMapping("/hell-client4")
    @ResponseBody
    public String hellClient4(String hell) {

        HellReq hellReq = new HellReq();

        if (hell == null) {
            hellReq.setHellReq("yugj test");
        } else {
            hellReq.setHellReq(hell);
        }

        HellResp rs = hellStub3.hell3(hellReq);

        return "rest template resp : " + rs;

    }

    @RequestMapping("/hell-client5")
    @ResponseBody
    @HystrixCommand(commandKey = "rest-serv",fallbackMethod = "testTimeout")
    public String hellClient5(String hell) {

        return hystrixTest(hell);
    }

    public String hystrixTest(String hell) {
        String reqUrl = "http://localhost:9006/rest-sv/hell";

        HttpHeaders requestHeaders = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        requestHeaders.setContentType(type);
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());

        HellReq param = new HellReq();
        param.setHellReq(hell);

        HttpEntity<Object> requestEntity = new HttpEntity<>(param, requestHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(reqUrl, HttpMethod.POST, requestEntity, String.class);
        return response.getBody();
    }

    private String testTimeout(String hell) {
        return "time out";
    }


}
