package indi.yugj.test.springcloud.swagger.hell;

import indi.yugj.test.springcloud.swagger.hell.schema.HellReq;
import indi.yugj.test.springcloud.swagger.hell.schema.HellResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Created by yugj on 18/6/13 17:18.
 */
@RestController
@RequestMapping("/v1/hell2")
@Api(description = "hell接口测试demo2")
public class HellController2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(HellController2.class);

    @ApiOperation("hell-test api 中文")
    @RequestMapping(value = "/hellTest2",method = RequestMethod.POST)
    public HellResp hellTest(@RequestBody HellReq hellReq) {

        LOGGER.info("hell req: {}", hellReq);

        HellResp resp = new HellResp();
        resp.setNameResp(hellReq.getName());
        resp.setUserIdResp(hellReq.getUserId());


        return resp;
    }




}
