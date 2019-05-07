package indi.yugj.test.springcloud.basetest.lambda;

/**
 * @author yugj
 * @date 18/10/8 21:02.
 */
public class Test1 {

    public static void main(String[] args){

        new Thread(
                () -> {
                    sleep();
                    System.out.println("hell");
                    sleep();
                    System.out.println("hell");
                    sleep();
                    System.out.println("hell");
                    sleep();
                    System.out.println("hell");
                    sleep();
                    System.out.println("hell");
                }
        ).start();

        new Thread(
                () -> hell2()
        ).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                System.out.println("runnable");
                sleep();
                System.out.println("runnable");
                sleep();
                System.out.println("runnable");
                sleep();
                System.out.println("runnable");
                sleep();
                System.out.println("runnable");
            }
        }).start();
    }

    public static void hell2() {
        sleep();
        System.out.println("print");
        sleep();
        System.out.println("print");
        sleep();
        System.out.println("print");
        sleep();
        System.out.println("print");
        sleep();
        System.out.println("print");
    }

    private static void sleep()  {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
