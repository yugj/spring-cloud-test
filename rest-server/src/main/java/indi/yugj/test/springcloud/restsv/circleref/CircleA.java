package indi.yugj.test.springcloud.restsv.circleref;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yugj
 * @date 18/8/8 18:59.
 */
public class CircleA {

    private String hell;

    public String getHell() {
        return hell;
    }

    public void setHell(String hell) {
        this.hell = hell;
    }

    private CircleB b;

    public CircleB getB() {
        return b;
    }

    public void setB(CircleB b) {
        this.b = b;
    }
}
