package indi.yugj.test.springclound.swagger.hell.schema;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author yugj
 * @date 18/8/24 19:39.
 */
public class CgiResp<T> {

    @ApiModelProperty("返回码")
    private String code;
    @ApiModelProperty("返回描述")
    private String msg;
    @ApiModelProperty("返回报文对象")
    private T data;

    public CgiResp(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public CgiResp(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
