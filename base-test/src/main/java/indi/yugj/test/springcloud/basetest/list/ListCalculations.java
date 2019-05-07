package indi.yugj.test.springcloud.basetest.list;

import java.util.ArrayList;
import java.util.List;

/**
 * list calculations test
 * @author yugj
 * @date 2019/1/2 上午9:52.
 */
public class ListCalculations {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        List<String> list2 = new ArrayList<String>();
        list2.add("C");
        list2.add("B");
        list2.add("D");

        // 并集
        list1.addAll(list2);
        System.out.println("list1 + list2");
        System.out.println(list1.toString());

        // 去重复并集
        list2.removeAll(list1);
        list1.addAll(list2);


        // 交集
        list1.retainAll(list2);

        // 差集
        list1.removeAll(list2);
    }
}
