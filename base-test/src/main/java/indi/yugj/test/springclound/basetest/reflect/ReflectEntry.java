package indi.yugj.test.springclound.basetest.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yugj
 * @date 18/8/9 15:20.
 */
public class ReflectEntry {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, InterruptedException {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            reflectInvoke();
        }

        long end = System.currentTimeMillis();
        long cost = end - start;
        System.out.println("end cost " + cost);
        Thread.sleep(1000000L);

    }

    public  static void reflectInvoke() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object obj = HellDemo.class.newInstance();
        Method method = HellDemo.class.getDeclaredMethod("hell");
        method.invoke(obj);
    }

    public static void newInvoke() {

        HellDemo demo = new HellDemo();
        demo.hell();
    }
}
