package indi.yugj.test.springclound.basetest.extend;

/**
 * Description:
 * Created by yugj on 18/7/14 18:06.
 */
public abstract class BaseHell {

    String key;
    String value;

    BaseHell(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public abstract String hell();

}
