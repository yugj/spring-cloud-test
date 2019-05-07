package indi.yugj.test.springcloud.basetest.chineseconvert.opencc4j;

import com.github.houbb.opencc4j.util.ZhConverterUtil;

/**
 * Description:中文转换工具
 * Created by yugj on 18/7/16 16:31.
 */
public class ChineseConvertUtil {


    public static synchronized String convertToTraditional(String original) {

        long startTime = System.currentTimeMillis();
        String result = ZhConverterUtil.convertToTraditional(original);
        long endTime = System.currentTimeMillis();


        long cost = endTime - startTime;

        if (cost > 20) {
            System.out.println("convertToTraditional cost:" + cost);
        }

        return result;

    }

}
