package cn.yugj.test.nacos.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yugj
 * @date 2020/6/29 4:50 下午.
 */
@RestController
public class NacosProviderEndpoint {

    @Autowired
    private NacosConfProperties nacosConfProperties;
    @Autowired
    private NacosExtProperties nacosExtProperties;

    @Autowired
    private Environment environment;

    /**
     * curl localhost:9001/echo/xxx
     */
    @GetMapping(value = "/test/{stime}")
    public String test(@PathVariable Integer stime) throws InterruptedException {
        Thread.sleep(stime);
        System.out.println("sleep :" + stime);
        return "ok";
    }

    /**
     * curl localhost:9001/echo/xxx
     */
    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        String sop = nacosConfProperties.getSop();
        System.out.println("nacos prop sop val:" + sop);

        String sop2 = environment.getProperty("jwt.sop");
        System.out.println("nacos prop env val:" + sop2);

        String ext = nacosExtProperties.getTest();
        System.out.println("ext :" + ext);

        return "Hello Nacos Discovery " + string;
    }
}
