package indi.yugj.test.springclound.restsv.hell;

import javax.validation.constraints.NotNull;

/**
 * Description:
 * Created by yugj on 18/7/2 17:02.
 */
public class HellReq {

    @NotNull
    public String hellReq;

    public String getHellReq() {
        return hellReq;
    }

    public void setHellReq(String hellReq) {
        this.hellReq = hellReq;
    }
}
