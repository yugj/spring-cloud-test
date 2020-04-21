package consulgrpcclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yugj
 * @date 2020/2/26 16:51.
 */
@RestController
public class TestController {

    @Autowired
    private GrpcClientService2 client;

    private static final Logger logger = LoggerFactory.getLogger(TestController.class.getName());


    @GetMapping("/hell")
    public String hell() {

        logger.info("hello client");

        client.sayHell();

        return "ok";
    }

}
