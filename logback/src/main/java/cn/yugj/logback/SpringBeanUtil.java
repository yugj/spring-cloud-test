package cn.yugj.logback;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 */
@Component
public class SpringBeanUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext ctx){
        context = ctx;
    }

    /**
     * 通过类型取java bean
     * @param clazz clazz类型
     * @param <T>
     * @return
     */
    public static <T> T get(Class<T> clazz) {
        return context.getBean(clazz);
    }

    /**
     * 按名称取java bean
     * @param name bean名称
     * @return bean实例
     */
    public static Object get(String name){
        return context.getBean(name);
    }

    /**
     * 通过java bean类型取java bean名称
     * @param clazz bean type
     * @return bean name
     */
    public static String getBeanNameForType(Class<?> clazz){
        String[] names = context.getBeanNamesForType(clazz);
        if(names == null || names.length == 0){
            return null;
        }
        return names[0];
    }

    /**
     * 通过bean类型去所有的java bean
     * @param clazz bean type
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> clazz){
        return context.getBeansOfType(clazz);
    }
}