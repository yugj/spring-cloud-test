package indi.yugj.test.springcloud.ribbon.eureka;

/**
 * @author yugj
 * @date 18/10/29 21:34.
 */
public class EurekaInstance {

    private String ipAddr;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }
}
