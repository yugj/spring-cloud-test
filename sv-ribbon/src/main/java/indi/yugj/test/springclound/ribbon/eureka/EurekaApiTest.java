package indi.yugj.test.springclound.ribbon.eureka;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;

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

        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            Thread.sleep(500L);

            String msg = testCoreApi("192.168.1.138", "UP",baseTemplate);
            writeTrace(msg, i);
        }


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
