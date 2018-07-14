import java.lang.annotation.*;

/**
 * Description:
 * Created by yugj on 18/7/3 16:03.
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface NeedCache {

    String key() default "";
}
