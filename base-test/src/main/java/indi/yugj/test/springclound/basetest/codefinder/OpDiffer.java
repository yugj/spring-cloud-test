package indi.yugj.test.springclound.basetest.codefinder;

import java.io.*;
import java.util.ArrayList;
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

        List<String> allOp = readOp(all);
        List<String> aliveOp = readOp(alive);

        allOp.removeAll(aliveOp);

        for (String op : allOp) {
            System.out.println(op);
        }


    }

    private List<String> readOp(File file) {

        List<String> strList = new ArrayList<String>();

        InputStreamReader read = null;
        BufferedReader reader = null;

        try {
            read = new InputStreamReader(new FileInputStream(file),"utf-8");
            reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {
                strList.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return strList;

    }

}
