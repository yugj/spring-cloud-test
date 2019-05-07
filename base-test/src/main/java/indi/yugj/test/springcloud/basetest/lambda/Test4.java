package indi.yugj.test.springcloud.basetest.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author yugj
 * @date 18/10/8 22:13.
 */
public class Test4 {

    public static void main(String[] args) {
        //New way:
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.stream().map((x) -> x*x).forEach(System.out::println);
    }
}
