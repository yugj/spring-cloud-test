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
        String aliveOpPath = "/Users/yugj/Documents/tmp/opfinder/alive-summary";

        File allFile = new File(allOpPath);
        File aliveFile = new File(aliveOpPath);

//        new OpDiffer().differ(allFile, aliveFile);

        System.out.println("-----------------------------------");

        String oldAlive = "/Users/yugj/Documents/tmp/opfinder/notalive-190118";
        String newAlive = "/Users/yugj/Documents/tmp/opfinder/notalive-190121";

        File oldFile = new File(oldAlive);
        File newFile = new File(newAlive);

        System.out.println("------------>>old differ to new");
        new OpDiffer().differ(oldFile, newFile);
        System.out.println("------------>>new differ to old");
        new OpDiffer().differ(newFile, oldFile);


    }

    /**
     * all - alive 差集
     * @param all
     * @param alive
     */
    private void differ(File all, File alive) {

        List<String> allOp = FileReader.readOp(all);
        List<String> aliveOp = FileReader.readOp(alive);

        allOp.removeAll(aliveOp);

        for (String op : allOp) {
            System.out.println(op);
        }


    }


}
