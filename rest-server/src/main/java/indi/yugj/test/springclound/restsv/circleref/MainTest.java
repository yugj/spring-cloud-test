package indi.yugj.test.springclound.restsv.circleref;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yugj
 * @date 18/8/8 19:04.
 */
public class MainTest {



    public static void main(String[] args) {

        CircleB b = new CircleB();
        b.setHell("hell b");

        CircleA a = new CircleA();
        a.setHell("hell a");

        b.setA(a);
        a.setB(b);

        String hell2 = JSON.toJSONString(a, SerializerFeature.DisableCircularReferenceDetect);
    }
}
