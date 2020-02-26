package cn.yugj.test.consulgrpcclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author yugj
 * @date 2020/2/26 16:51.
 */
@RestController
public class TestController {

    @Autowired
    private GrpcClientService client;

    @GetMapping("/hell")
    public String hell() throws ExecutionException, InterruptedException {
        client.sayHello();

        return "ok";
    }

}
