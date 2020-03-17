package consulgrpcclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author yugj
 * @date 2020/2/26 16:51.
 */
@RestController
public class TestController {

    @Autowired
    private GrpcClientService2 client;

    private static final Logger logger = Logger.getLogger(TestController.class.getName());


    @GetMapping("/hell")
    public String hell() {

        logger.info("hello client");

        client.sayHell();

        return "ok";
    }

}
