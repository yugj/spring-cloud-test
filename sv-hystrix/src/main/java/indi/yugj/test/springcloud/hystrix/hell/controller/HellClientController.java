package indi.yugj.test.springcloud.hystrix.hell.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import indi.yugj.test.springcloud.hystrix.feign.HellStub;
import indi.yugj.test.springcloud.hystrix.feign.HellStub3;
import indi.yugj.test.springcloud.hystrix.hell.schema.HellResp;
import indi.yugj.test.springcloud.hystrix.hell.service.HystrixRestTemplateTestService;
import indi.yugj.test.springcloud.hystrix.feign.HellStub2;
import indi.yugj.test.springcloud.hystrix.hell.schema.HellReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(HellClientController.class);

    /**
     * 接收入参并透传到server
     * hell = sleep server 将sleep 5s
     * hell = error server 将抛出运行时异常
     * @param hell param
     * @return test ok
     */
    @RequestMapping("/hell-client")
    @ResponseBody
    public String hellClient(String hell) {

        HellReq hellReq = new HellReq();

        if (hell == null) {
//            hellReq.setHellReq("中文");
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

        try {
            String rs = hellService.hell(hell);
            return "rest template resp : " + rs;
        } catch (Exception e) {
            log.warn("error --> {}" + e.getMessage(),e);
            return e.getMessage();
        }




    }

    @RequestMapping("/hell-client4")
    @ResponseBody
    public String hellClient4(String hell) {

        HellReq hellReq = new HellReq();

        if (hell == null) {
            hellReq.setHellReq("中文");
        } else {
            hellReq.setHellReq(hell);
        }

        HellResp rs = hellStub3.hell3(hellReq);

        return "rest template resp : " + rs;

    }

    @RequestMapping("/hell-client5")
    @ResponseBody
    public String hellClient5(String hell) {

        return hystrixTest(hell);
    }

    @HystrixCommand(commandKey = "hystrix-command-b",fallbackMethod = "testTimeout")
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

    /**
     * for 循环请求
     * @param hell
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/hell-client6")
    @ResponseBody
    public String hellClient6(String hell) throws InterruptedException {

        HellReq hellReq = new HellReq();
        if (hell == null) {
            hellReq.setHellReq("yugj test");
        } else {
            hellReq.setHellReq(hell);
        }

        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            Thread.sleep(300L);

            HellResp resp = hellStub.hell(hellReq);
            log.info("---------------->>" + resp.getHellResp());

        }

        return "hell";
    }

    /**
     * 400
     * @param hell
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/hell-client7")
    @ResponseBody
    public String hellClient7(String hell) throws InterruptedException {

        HellReq hellReq = new HellReq();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Thread.sleep(300L);
            HellResp resp = hellStub.hell(hellReq);
            log.info("---------------->>" + resp.getHellResp());

        }

        return "hell";
    }


    /**
     * good
     * @param hell
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/hell-client8")
    @ResponseBody
    public String hellClient8(String hell) throws InterruptedException {

        HellReq hellReq = new HellReq();
        hellReq.setHellReq("good");

        HellResp resp = hellStub.good(hellReq);
        log.info("---------------->>" + resp.getHellResp());

        return "hell" + resp.getHellResp();
    }


    private String testTimeout(String hell) {
        return "time out";
    }


}
