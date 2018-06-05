package wangmian.www.firstcpp;

/**
 * Created by wangmian on 2018/6/5.
 * you can contact me with wangmian1994@outlook.com
 */

public class NativeHelper {

    static {
        System.loadLibrary("my-lib");
    }
    public native String hellocpp();
}
