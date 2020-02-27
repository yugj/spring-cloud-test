package cn.yugj.test.consulgrpc2.grpcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author yugj
 * @date 2020/2/27 23:58.
 */
@RestController
public class TestController {


    @Autowired
    private GreeterClient client;
    @Autowired DataProperties dataProperties;

    private static final Logger logger = Logger.getLogger(TestController.class.getName());


    @GetMapping("/hell")
    public String hell() {

        logger.info("hell");

        client.hell();

        return "ko" + dataProperties.getName();
    }

}
