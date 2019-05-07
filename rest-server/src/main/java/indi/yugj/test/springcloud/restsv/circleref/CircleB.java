package indi.yugj.test.springcloud.restsv.circleref;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yugj
 * @date 18/8/8 18:59.
 */
public class CircleB {

    private String hell;

    private CircleA a;

    public String getHell() {
        return hell;
    }

    public void setHell(String hell) {
        this.hell = hell;
    }

    public CircleA getA() {
        return a;
    }

    public void setA(CircleA a) {
        this.a = a;
    }
}
