package indi.yugj.test.springcloud.ribbon;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

/**
 * @author yugj
 * @date 2019/11/9 06:37.
 */
public class CustomPing4Ribbon implements IPing {


    @Override
    public boolean isAlive(Server server) {
        String urlStr = "http://";
        urlStr += server.getId();

        boolean isAlive = false;

        HttpClient httpClient = new DefaultHttpClient();
        HttpUriRequest getRequest = new HttpGet(urlStr);
        try {
            HttpResponse response = httpClient.execute(getRequest);
            isAlive = (response.getStatusLine().getStatusCode() == 200);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            // Release the connection.
            getRequest.abort();
        }

        return isAlive;
    }
}
