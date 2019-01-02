package indi.yugj.test.springclound.basetest.codefinder;

import java.io.File;
import java.util.List;

/**
 * @author yugj
 * @date 2018/12/29 下午3:13.
 */
public class OpDiffer {

    public static void main(String[] args) {

        String allOpPath = "/Users/yugj/Documents/tmp/opfinder/all";
        String aliveOpPath = "/Users/yugj/Documents/tmp/opfinder/alive";

        File allFile = new File(allOpPath);
        File aliveFile = new File(aliveOpPath);

        new OpDiffer().differ(allFile, aliveFile);


    }

    private void differ(File all, File alive) {

        List<String> allOp = FileReader.readOp(all);
        List<String> aliveOp = FileReader.readOp(alive);

        allOp.removeAll(aliveOp);

        for (String op : allOp) {
            System.out.println(op);
        }


    }


}
