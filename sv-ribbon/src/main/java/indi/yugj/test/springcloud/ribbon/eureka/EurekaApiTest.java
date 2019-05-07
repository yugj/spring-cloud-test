package indi.yugj.test.springcloud.ribbon.eureka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author yugj
 * @date 18/10/23 22:54.
 */
public class EurekaApiTest {

    /**
     * 测试注册上去后是否可以立即访问
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();

        Integer timeout = 3000;
        httpRequestFactory.setConnectionRequestTimeout(timeout);
        httpRequestFactory.setConnectTimeout(timeout);
        httpRequestFactory.setReadTimeout(timeout);

        RestTemplate baseTemplate = new RestTemplate(httpRequestFactory);

        String dataLine = DateFormatUtils.format(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            List<EurekaInstance> instanceList = getRestServerInstance();

            if (CollectionUtils.isEmpty(instanceList)) {
                System.out.println("no instance,return");
                continue;
            }

            Thread.sleep(500L);
            for (EurekaInstance instance : instanceList) {
                String instanceInfo = instance.getIpAddr() + "-" + instance.getStatus();
                System.out.println(dataLine + "instanceInfo," + instanceInfo);
                writeTrace(instanceInfo, i);

                String msg = testCoreApi(instance.getIpAddr(), instance.getStatus(),baseTemplate);
                writeTrace(msg, i);
            }
        }

    }

    private static List<EurekaInstance> getRestServerInstance() {

        String dataLine = DateFormatUtils.format(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss");

        String getApi = "http://localhost:9000/eureka/apps/rest-server";

        RestTemplateBuilder builder = new RestTemplateBuilder();

        ResponseEntity hell;
        try {
            hell = builder.build().getForEntity(getApi, String.class, new HashMap<>());
        } catch (HttpClientErrorException e) {
            System.out.println(e.getMessage());
            return null;
        }

        hell.getStatusCodeValue();
        String resp = hell.getBody().toString();
        System.out.println(dataLine + " eureka resp:" + resp);

        JSONObject obj = JSON.parseObject(hell.getBody().toString());
        String application = obj.get("application").toString();

        JSONObject instances = JSON.parseObject(application);

        List<EurekaInstance> instanceList = JSON.parseArray(instances.get("instance").toString(), EurekaInstance.class);

        return instanceList;

    }

    private static String testCoreApi(String ip,String status,RestTemplate template) throws IOException {

        String coreApi = "http://" + ip + ":9010/ribbon/hell-client?hell=test";

        String dataLine = DateFormatUtils.format(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss");

        try {

            ResponseEntity<String> responseEntity = template.getForEntity(coreApi, String.class);

            System.out.println(dataLine + " core api resp:" + responseEntity.getBody());
            return responseEntity.getBody();
        } catch (Exception e) {

            if ("UP".equals(status)) {
                e.printStackTrace();
                return dataLine + " -----UP AND FAILED" + e;
            }

            System.out.println("Status:" + status + ",error " + e.getMessage());
            return dataLine + " status," + status + " " + e;
        }

    }


    private static void writeTrace(String data,Integer index) throws IOException {
        File file = new File("//Users/yugj/Documents/hell/test-eureka/trace.log");
        if (!file.exists()) {
            file.createNewFile();
        }

        String dataLine = DateFormatUtils.format(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss");
        dataLine += data;
        dataLine += "------>>";
        dataLine += index;
        dataLine += "\n\n";

        FileUtils.write(file, dataLine, "UTF-8", true);
    }
}
