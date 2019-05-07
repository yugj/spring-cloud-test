package indi.yugj.test.springcloud.swagger.hell.schema;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Description:
 * Created by yugj on 18/6/13 17:20.
 */
@ApiModel("模型hell")
public class HellReq {

    @ApiModelProperty(value = "用户ID",example = "8888")
    private Long userId;

    @ApiModelProperty(name = "user name",value = "用户名",example = "yugj")
    private String name;

    @ApiModelProperty(name = "sub子类",value = "子类属性",required=true)
    private SubHell subHell;

    public SubHell getSubHell() {
        return subHell;
    }

    public void setSubHell(SubHell subHell) {
        this.subHell = subHell;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
