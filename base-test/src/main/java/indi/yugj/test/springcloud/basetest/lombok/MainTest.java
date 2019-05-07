package indi.yugj.test.springcloud.basetest.lombok;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 *
 * @author yugj
 * @date 18/8/16 10:31.
 */
public class MainTest {

    @Test
    public void testBase() {
        BaseVo vo = new BaseVo();
        vo.setId(88L);
        vo.setName("yugj");
    }

    @Test
    public void testBasic() {
        LombVo vo = new LombVo();
        vo.setId(88L);
        vo.setName("yugj");

        System.out.println(JSON.toJSONString(vo));

    }

    @Test
    public void testChain() {

        LombVo vo = new LombVo();
        vo.setId(88L).setName("yugj");

        System.out.println(JSON.toJSONString(vo));

    }

    @Test
    public void testBuilder() {
        LombBuildVo vo = LombBuildVo.builder().id(88L).name("yugj").build();
        System.out.println(JSON.toJSONString(vo));

    }
}
