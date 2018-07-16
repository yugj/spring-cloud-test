package indi.yugj.test.springclound.basetest.extend;

/**
 * Description:
 * Created by yugj on 18/7/14 18:16.
 */
public class HellA extends BaseHell{


    HellA(String key, String value) {
        super(key, value);
    }

    @Override
    public String hell() {
        return "hell-a," + this.key + "-" + this.value;
    }
}
