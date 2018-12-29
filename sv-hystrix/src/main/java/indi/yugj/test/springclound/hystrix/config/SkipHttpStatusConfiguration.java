package indi.yugj.test.springclound.hystrix.config;

import feign.codec.ErrorDecoder;

/**
 * 配置忽略特定http 错误请求
 *
 * @author yugj
 * @date 2018/12/29 下午5:19.
 */
public class SkipHttpStatusConfiguration {

    public ErrorDecoder errorDecoder() {

        return (methodKey, response) -> {

            int status = response.status();

            if (status == 400) {

//                String body = "Bad request";
//
//                try {
//                    body = IOUtils.toString(response.body().asReader());
//                } catch (Exception ignored) {
//
//                }
//                HttpHeaders httpHeaders = new HttpHeaders();
//
//                response.headers().forEach((k, v) -> httpHeaders.add("feign-" + k, StringUtils.join(v, ",")));
//
//                return new ErrorDecoder.Default();

                return null;

            } else {
                return new RuntimeException("Response Code " + status);
            }
        };
    }
}
