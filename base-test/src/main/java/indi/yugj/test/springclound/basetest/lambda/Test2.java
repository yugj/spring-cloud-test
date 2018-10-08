package indi.yugj.test.springclound.basetest.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author yugj
 * @date 18/10/8 21:15.
 */
public class Test2 {

    public static void main(String[] args) {

        exe(new TestFunctionIs() {
            @Override
            public void sth() {
                System.out.println("normal ex");
            }
        });

        exe(
                () -> System.out.println("lambda ex")
        );

        String hell = "hell x";
        String hell2 = "hell x2";
        exe2(
                (is) -> {
                    System.out.println("is2:" + hell);
                }, hell2
        );

        //New way:
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(n -> System.out.println(n));

        //or we can use :: double colon operator in Java 8
        list.forEach(System.out::println);

    }

    private static void exe(TestFunctionIs is) {
        is.sth();
    }

    private static void exe2(TestFunctionIs2 is, String hell) {
        is.sth(hell);
        System.out.println("exe2:" + hell);
    }

}