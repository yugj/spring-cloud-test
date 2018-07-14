package indi.yugj.test.springclound.swagger.hell;

import indi.yugj.test.springclound.swagger.hell.schema.HellReq;
import indi.yugj.test.springclound.swagger.hell.schema.HellResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:handler接口维护测试
 * Created by yugj on 18/6/27 09:40.
 */
@Service
@RequestMapping("/h1/hell")
@Api(description = "hell接口测试demo handler")
public class HellHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(HellHandler.class);

    @ApiOperation("hell-test api 中文")
    @RequestMapping("/hellTest")
    public HellResp hellTest(@RequestBody HellReq hellReq) {

        LOGGER.info("hell req: {}", hellReq);

        HellResp resp = new HellResp();

        return resp;
    }

}
