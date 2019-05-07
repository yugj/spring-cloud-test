package indi.yugj.test.springcloud.basetest.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  fast json test
 * </pre>
 *
 * @author yugj
 * @date 18/8/8 17:12.
 */
public class FastJsonTest {

    @Test
    public void refObjTest() {

        List<MainObj> list = new ArrayList<>();
        RefObj refObj = new RefObj();
        refObj.setHell("hell obj");
        refObj.setMsg("msg");

        MainObj mainObj = new MainObj();
        mainObj.setRefObj(refObj);
        MainObj mainObj1 = new MainObj();
        mainObj1.setRefObj(refObj);
        MainObj mainObj2 = new MainObj();
        mainObj2.setRefObj(refObj);

        list.add(mainObj);
        list.add(mainObj2);
        list.add(mainObj1);

//        refObj.setMainObj(mainObj);

        String hell = JSON.toJSONString(list);
        String hell2 = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);


        System.out.println(hell);
        System.out.println(hell2);

        List<MainObj> rs = JSON.parseArray(hell, MainObj.class);

        for (MainObj obj : rs) {
            System.out.println(obj.getRefObj().getHell());
        }

    }
}

class MainObj {

    private RefObj refObj;

    public RefObj getRefObj() {
        return refObj;
    }

    public void setRefObj(RefObj refObj) {
        this.refObj = refObj;
    }
}

class RefObj {

//    private MainObj mainObj;
//
//    public MainObj getMainObj() {
//        return mainObj;
//    }
//
//    public void setMainObj(MainObj mainObj) {
//        this.mainObj = mainObj;
//    }

    private String hell;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getHell() {
        return hell;
    }

    public void setHell(String hell) {
        this.hell = hell;
    }
}

