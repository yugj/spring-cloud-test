package indi.yugj.test.springclound.basetest.chineseconvert.opencc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description:
 * Created by yugj on 18/7/16 16:09.
 */
public class OpenCCTest {

    public static void main(String[] args) {

        String hell = "台湾";

        long startTime = System.currentTimeMillis();
        String rs = sc2tw(hell);
        long endTime = System.currentTimeMillis();

        System.out.println("rs:" + rs + ",cost:" + (endTime - startTime));
    }

    public static String sc2tw(String content) {
        try {
            StringBuffer sb = new StringBuffer("");
            Process ps = Runtime.getRuntime().exec("/usr/local/s2tw.sh \"" + content + "\"");
            BufferedReader in = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            String line = null;
            ps.waitFor();
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            in.close();
            if (sb.indexOf("\"") == 0) {
                sb = sb.deleteCharAt(0);
            }
            if (sb.lastIndexOf("\"") == sb.length() - 1) {
                sb = sb.deleteCharAt(sb.length() - 1);
            }
            ps.destroy();
            line = null;
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return content;
    }
}
