package indi.yugj.test.springclound.basetest.concurrent.runcall;

import java.util.concurrent.*;

/**
 * callable有返回 runnable无
 * callable可🏃异常
 * FutureTask 支持两则,使用runnable最终被转callable执行
 * Future get阻塞执行 awaitDone逻辑
 * else if (s == COMPLETING) // cannot time out yet
 *   Thread.yield();
 *
 * @author yugj
 * @date 18/10/9 10:34.
 */
public class RunCallTest {

    private static ExecutorService service = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        service.execute(() -> System.out.println("run"));

        Future<String> hell = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "call+";
            }
        });
        System.out.println("call:" + hell.get());

        Future<String> hell2 = service.submit(
                () -> "call++"
        );
        System.out.println("call2:" + hell2.get());

        FutureTask<String> ft = new FutureTask<String>(
                () -> "future task with callable"
        );

        Future hell3 = service.submit(ft);
        Thread.sleep(1000L);
        System.out.println("call3:" + ft.get());
        System.out.println("call3:" + hell3.get());


    }
}
