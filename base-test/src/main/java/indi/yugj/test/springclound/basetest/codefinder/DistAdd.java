package indi.yugj.test.springclound.basetest.codefinder;

import java.io.File;
import java.util.List;

/**
 * @author yugj
 * @date 2019/1/2 上午9:46.
 */
public class DistAdd {

    public static void main(String[] args) {

        List<String> list1 = FileReader.readOp(new File("/Users/yugj/Documents/tmp/opfinder/alive-181229"));
        List<String> list2 = FileReader.readOp(new File("/Users/yugj/Documents/tmp/opfinder/alive-190102"));

        list2.removeAll(list1);
        list1.addAll(list2);

        for (String op : list1) {
            System.out.println(op);
        }

    }
}
