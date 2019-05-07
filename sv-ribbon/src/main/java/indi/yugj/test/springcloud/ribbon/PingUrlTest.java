package indi.yugj.test.springcloud.ribbon;

import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;

/**
 * @author yugj
 * @date 2018/11/8 下午4:19.
 */
public class PingUrlTest {

    public static void main(String[] args) {
        PingUrl p = new PingUrl(false,"/info");
        p.setExpectedContent("true");
        Server s = new Server("www.baidu.com", 80);

        boolean isAlive = p.isAlive(s);
        System.out.println("isAlive:" + isAlive);
    }
}
