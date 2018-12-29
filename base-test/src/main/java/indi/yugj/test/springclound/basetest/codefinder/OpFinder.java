package indi.yugj.test.springclound.basetest.codefinder;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 查op
 *
 * @author yugj
 * @date 2018/12/29 上午11:28.
 */
public class OpFinder {

    private static List<String> opList = new ArrayList<>();


    public static void main(String[] args) {

        String rootPath = "/Users/yugj/mdev/migu/mgdm-sc/web-sop/src/main/java/cn/migudm/sop/biz";
        File root = new File(rootPath);

        OpFinder finder = new OpFinder();
        finder.finder(root);

        Collections.sort(opList);
        for (String op : opList) {
            System.out.println(op);
        }

    }


    private void finder(File file) {

        if (!file.isDirectory()) {
            return;
        }

        manager(file);

        File[] child = file.listFiles();

        if (child == null) {
            return;
        }

        for (File aChild : child) {
            finder(aChild);
        }
    }

    private void manager(File file) {

        File[] child = file.listFiles();

        if (child == null) {
            return;
        }


        for (File target : child) {

            if (target.isDirectory()) {
                continue;
            }

            String fileName = target.getName();

            if (fileName.matches(".*\\.java$")) {
                count(fileName);
            }
        }
    }

    private void count(String fileName) {

        if (fileName.contains("Handler")) {
            String op = fileName.replace("Handler.java", "");
            op = op.substring(0, 1).toLowerCase() + op.substring(1);
            opList.add(op);
        }

    }


}
