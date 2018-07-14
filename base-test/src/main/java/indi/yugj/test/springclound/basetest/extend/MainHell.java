package indi.yugj.test.springclound.basetest.extend;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Created by yugj on 18/7/14 18:24.
 */
public class MainHell {

    public static final Map<String, Class> CLAZZ_MAP = new HashMap<>();

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //init
        CLAZZ_MAP.put("hella", HellA.class);
        CLAZZ_MAP.put("hellb", HellB.class);

        //routing key
        String hellKey = "hellb";
        //biz value
        String hellValue = "hell-tar";

        Class targetClazz = CLAZZ_MAP.get(hellKey);

        //to cache the rs
        Constructor constructor = targetClazz.getDeclaredConstructor(String.class, String.class);

        constructor.setAccessible(true);
        BaseHell targetObj = (BaseHell)constructor.newInstance(hellKey, hellValue);
        String rs = targetObj.hell();

        System.out.println(rs);

    }
}
