package indi.yugj.test.springclound.swagger.hell.schema;

import io.swagger.annotations.ApiModelProperty;

/**
 * Description:
 * Created by yugj on 18/6/13 17:21.
 */
public class HellResp {

    @ApiModelProperty("用户ID")
    private Long userIdResp;

    @ApiModelProperty("用户名")
    private String nameResp;


    public Long getUserIdResp() {
        return userIdResp;
    }

    public void setUserIdResp(Long userIdResp) {
        this.userIdResp = userIdResp;
    }

    public String getNameResp() {
        return nameResp;
    }

    public void setNameResp(String nameResp) {
        this.nameResp = nameResp;
    }
}
