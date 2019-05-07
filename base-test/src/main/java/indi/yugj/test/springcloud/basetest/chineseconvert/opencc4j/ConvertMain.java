package indi.yugj.test.springcloud.basetest.chineseconvert.opencc4j;

import com.github.houbb.opencc4j.util.ZhConverterUtil;
import org.junit.Test;

/**
 * Description:
 * Created by yugj on 18/7/16 15:20.
 */
public class ConvertMain {

    @Test
    public void convertToSimpleTest() {


    }


    @Test
    public void convertToTraditional() {

        String original = "hell";

        long startTime = System.currentTimeMillis();
        String result = ZhConverterUtil.convertToTraditional(original);
        long endTime = System.currentTimeMillis();

        System.out.println("rs:" + result + ",cost:" + (endTime - startTime));

    }

    public static void main(String[] args) {

        String original = "中國";

        long startTime = System.currentTimeMillis();
        String result = ChineseConvertUtil.convertToTraditional(original);
        long endTime = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        String result2 = ChineseConvertUtil.convertToTraditional("中国");
        long endTime2 = System.currentTimeMillis();

        System.out.println("rs:" + result + ",cost:" + (endTime - startTime));
        System.out.println("rs:" + result2 + ",cost:" + (endTime2 - startTime2));
    }
}
