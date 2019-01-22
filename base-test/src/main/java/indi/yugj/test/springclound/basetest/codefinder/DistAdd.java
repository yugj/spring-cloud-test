package indi.yugj.test.springclound.basetest.codefinder;

import java.io.File;
import java.util.List;

/**
 * 去重补集
 * @author yugj
 * @date 2019/1/2 上午9:46.
 */
public class DistAdd {

    public static void main(String[] args) {

        List<String> summary = FileReader.readOp(new File("/Users/yugj/Documents/tmp/opfinder/alive-summary"));
        List<String> aliveNew = FileReader.readOp(new File("/Users/yugj/Documents/tmp/opfinder/alive-190121"));

        aliveNew.removeAll(summary);
        summary.addAll(aliveNew);

        for (String op : summary) {
            System.out.println(op);
        }

    }
}
