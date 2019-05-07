package indi.yugj.test.springcloud.apidoc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yugj
 * @date 18/8/15 16:35.
 */
@Controller
@RequestMapping("/apidoc/hell")
public class HellController {


    /**
     * @api {post} /apidoc/hell
     * @apiDescription  test apidoc
     * @apiName test 1
     * @apiVersion 1.1.0
     * @apiParam {String} hell hell desc
     * @apiSuccess success
     * @return success failed
     */
    @RequestMapping("/test1")
    public String test1(String hell) {
        return "hell";
    }

    /**
     * @api {post} /apidoc/hell2
     * @apiDescription  test apidoc2
     * @apiName test 2
     * @apiVersion 1.1.0
     * @apiParam {String} hell hell desc
     * @apiSuccess success
     * @return success failed
     */
    @RequestMapping("/test2")
    public String test2(String hell) {
        return "hell";
    }

}
