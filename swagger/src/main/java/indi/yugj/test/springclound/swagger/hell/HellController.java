package indi.yugj.test.springclound.swagger.hell;

import indi.yugj.test.springclound.swagger.hell.schema.HellReq;
import indi.yugj.test.springclound.swagger.hell.schema.HellResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Created by yugj on 18/6/13 17:18.
 */
@RestController
@RequestMapping("/v1/hell")
@Api(description = "hell接口测试demo")
public class HellController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HellController.class);

    @ApiOperation("hell-test api 中文")
    @RequestMapping("/hellTest")
    public HellResp hellTest(@RequestBody HellReq hellReq) {

        LOGGER.info("hell req: {}", hellReq);

        HellResp resp = new HellResp();


        return resp;
    }




}
