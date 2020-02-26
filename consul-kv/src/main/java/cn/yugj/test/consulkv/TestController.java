package cn.yugj.test.consulkv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yugj
 * @date 2020/2/26 20:15.
 */
@RestController
@RefreshScope
public class TestController {

    /**
     * 即使没有RefreshScope也可以动态刷新配置
     */
    @Autowired
    private DataProperties dataProperties;

    /**
     *  @Value需要配合 RefreshScope 类注解才能动态刷新
     *  建议使用DataProperties方式维护，代码更加模块化，避免分散配置
     */
    @Value("${hell}")
    private String hell;

    @GetMapping("/hell")
    public String hell() {
        System.out.println(dataProperties.getName());
        System.out.println(dataProperties.getAge());

        System.out.println(hell);

        return "Hello World ";
    }

}
