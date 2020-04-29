package indi.yugj.test.springcloud.hystrix.config;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

import static java.lang.String.format;

/**
 * @author yugj
 * @date 2020/4/29 9:13 上午.
 */
public class SkipHttpStatusErrorDecoder extends ErrorDecoder.Default {

    public SkipHttpStatusErrorDecoder() {
        super();
    }

    @Override
    public Exception decode(String methodKey, Response response) {

        int status = response.status();
        if (status == 400 || status == 404) {
            String message = statusFormat(methodKey, response);
            return new HystrixBadRequestException(message);
        }

        return super.decode(methodKey, response);
    }

    private String statusFormat(String methodKey, Response response) {

        String message = format("status %s reading %s", response.status(), methodKey);
        if (response.body() != null) {
            try {
                String body = Util.toString(response.body().asReader());
                message += "; content:\n" + body;
            } catch (Exception e) {
                //do nothing
            }
        }

        return message;
    }
}
