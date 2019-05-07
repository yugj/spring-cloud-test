package indi.yugj.test.springcloud.basetest.codefinder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yugj
 * @date 2019/1/2 上午9:47.
 */
class FileReader {

    static List<String> readOp(File file) {

        List<String> strList = new ArrayList<String>();

        InputStreamReader read = null;
        BufferedReader reader = null;

        try {
            read = new InputStreamReader(new FileInputStream(file), "utf-8");
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
