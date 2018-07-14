package indi.yugj.test.springclound.basetest.extend;

/**
 * Description:
 * Created by yugj on 18/7/14 18:17.
 */
public class HellB extends BaseHell{


    HellB(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String hell() {
        return "hell-b," + this.key + "-" + this.value;
    }
}
