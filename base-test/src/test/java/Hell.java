/**
 * Description:
 * Created by yugj on 18/7/3 16:02.
 */
public class Hell {

    public static void main(String[] args) {

        String.format("xxx%s", "hell");

    }

    /**
     * user-account-accountType
     * @param hell
     * @param xxx
     */
    @NeedCache(key = HellConstant.USER_KEY)
    public void hell(String hell,String xxx) {
        NeedCache needCache = null;
        String key = needCache.key();

    }

}

class  HellConstant {


    public final static String USER_KEY = "user-%s-%s";
}

