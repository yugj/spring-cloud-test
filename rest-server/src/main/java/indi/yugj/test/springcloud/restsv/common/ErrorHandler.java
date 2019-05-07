package indi.yugj.test.springcloud.restsv.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 内部异常处理
 * @author yugj
 * @date 18/8/29 15:08.
 */
@RestController
public class ErrorHandler extends AbstractErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    @Value("${error.path:/error}")
    private String errorPath;

    public ErrorHandler(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping(value = "${error.path:/error}", produces = "application/json;charset=UTF-8")
    public ResponseEntity error(HttpServletRequest request) throws IOException {

        String body = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));

        HttpStatus httpStatus = getStatus(request);
        int code = httpStatus.value();

        String originUri = new UrlPathHelper().getOriginatingRequestUri(request);
        LOGGER.warn("sys error,http status:{},originUri:{}",code,originUri);

        if (HttpStatus.NOT_FOUND.value() == code) {
            return new ResponseEntity<>(new CgiResp("404", "404"), HttpStatus.NOT_FOUND);
        }

        if (HttpStatus.UNAUTHORIZED.value() == code) {
            //返回401有助于浏览器识别弹出鉴权窗口 比如chrome浏览器,不然需要请求带鉴权数据,比较麻烦
            return new ResponseEntity<>(new CgiResp("401", "401"), HttpStatus.UNAUTHORIZED);
        }

        if (HttpStatus.METHOD_NOT_ALLOWED.value() == code) {
            return new ResponseEntity<>(new CgiResp("405", "405"), HttpStatus.METHOD_NOT_ALLOWED);
        }

        if (HttpStatus.BAD_REQUEST.value() == code) {
            return new ResponseEntity<>(new CgiResp("400", "400"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new CgiResp("500", "500"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public String getErrorPath() {
        return errorPath;
    }
}
