package indi.yugj.test.springclound.restsv.circleref;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yugj
 * @date 18/8/8 18:56.
 */
@Controller
@RequestMapping("/circle")
public class CircleRefController {

    @RequestMapping("/hell")
    @ResponseBody
    public String hell() {

        CircleB b = new CircleB();
        b.setHell("hell b");

        CircleA a = new CircleA();
        a.setHell("hell a");

        b.setA(a);
        a.setB(b);

        String hell2 = JSON.toJSONString(a, SerializerFeature.DisableCircularReferenceDetect);

        return "hell" + hell2;
    }



}
