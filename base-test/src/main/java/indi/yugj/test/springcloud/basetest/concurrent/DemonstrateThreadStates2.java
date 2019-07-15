package indi.yugj.test.springcloud.basetest.concurrent;

/**
 * 模拟线程周期
 *
 * @author yugj
 * @date 2019/7/12 下午3:56.
 */
public class DemonstrateThreadStates2 {

    static Thread thread1;

    public static void main(String[] args) {

        //创建线程1
        thread1 = new Thread(new TestThread1());

        // thread1 创建后 NEW state.
        System.out.println("State of thread1 after creating it - " + thread1.getState());
        thread1.start();

        // thread1 调用start后 变成 Runnable state
        System.out.println("State of thread1 after calling .start() method on it - " +
                thread1.getState());

    }

}

class TestThread1 implements Runnable {

    @Override
    public void run() {

        TestThread2 myThread = new TestThread2();
        Thread thread2 = new Thread(myThread);

        // 线程2创建 NEW state.
        System.out.println("State of thread2 after creating it - " + thread2.getState());
        thread2.start();

        // 线程2调用start 变成 Runnable state
        System.out.println("State of thread2 after calling .start() method on it - " +
                thread2.getState());

        // 调用sleep迫使当前线程进入sleep thread2 = timed waiting state
        try {
            //moving thread2 to timed waiting state
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("State of thread2 after calling .sleep() method on it - " +
                thread2.getState());

        try {
            // 调用join迫使线程结束到die
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of thread2 when it has finished it's execution - " +
                thread2.getState());
    }
}


class TestThread2 implements Runnable {

    @Override
    public void run() {
        // moving thread2 to timed waiting state
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of thread1 while it called join() method on thread2 -" +
                DemonstrateThreadStates2.thread1.getState());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}