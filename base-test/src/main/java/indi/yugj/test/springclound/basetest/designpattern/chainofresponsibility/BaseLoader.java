package indi.yugj.test.springclound.basetest.designpattern.chainofresponsibility;

/**
 * 责任链模式
 * 多个消费则处理同一个请求,请求则发送信息到责任链,责任链自己去负责消息传递处理
 * 请求则不关系消息处理方,请求沿着链路执行
 * @author yugj
 * @date 18/8/31 17:08.
 */
public abstract class BaseLoader {

    public static int INFO = 2;
    public static int DEBUG = 1;
    public static int ERROR = 3;

    protected int level;

    protected BaseLoader next;

    public void setNext(BaseLoader next) {
        this.next = next;
    }

    public void load(int level, String msg) {
        if (this.level >= level) {
            print(msg);
        }

        if (next != null) {
            next.load(level,msg);
        }
    }

    abstract protected void print(String msg);

}
