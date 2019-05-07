package indi.yugj.test.springcloud.basetest.exception;

/**
 * The compiler in the server VM now provides correct stack backtraces for all "cold" built-in exceptions.
 * For performance purposes, when such an exception is thrown a few times, the method may be recompiled.
 * After recompilation, the compiler may choose a faster tactic using preallocated exceptions that do not provide a stack trace.
 * To disable completely the use of preallocated exceptions, use this new flag: -XX:-OmitStackTraceInFastThrow.
 * <p>
 * 异常出现一定次数后 jvm会内部优化 丢失部分异常信息
 * 配置-XX:-OmitStackTraceInFastThrow强制不忽略堆栈信息
 *
 * @author yugj
 * @date 2019/1/2 下午4:00.
 */
public class OmitStackTraceInFastThrowTest {

    public static void main(String[] args) {
        int i = 0;
        String x = null;
        while (i < 100000000) {
            try {
                System.out.println("当前执行次数为：" + i);
                getNPE(x);
            } catch (Exception e) {
                int lth = e.getStackTrace().length;
                System.out.println("length：" + lth);
                e.printStackTrace();

                //正常 lth = 2这边如果=0 表示异常信息被丢失
                if (lth == 0) {
                    System.out.println("length = 0");
                    return;
                }
            }

            i++;
        }
    }

    private static void getNPE(String x) {
        System.out.println("当前字母为：" + x.toString());
    }
}
