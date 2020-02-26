package consulgrpcclient;

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

    @GetMapping("/hell")
    public String hell() {
        client.sayHell();

        return "ok";
    }

}
