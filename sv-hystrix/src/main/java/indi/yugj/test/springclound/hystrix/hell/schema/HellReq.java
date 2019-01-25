package indi.yugj.test.springclound.hystrix.hell.schema;

/**
 * Description:
 * Created by yugj on 18/7/2 17:02.
 */
public class HellReq {

    public HellReq() {

    }

    public HellReq(String hellReq) {
        this.hellReq = hellReq;
    }

    public String hellReq;

    public String getHellReq() {
        return hellReq;
    }

    public void setHellReq(String hellReq) {
        this.hellReq = hellReq;
    }
}
