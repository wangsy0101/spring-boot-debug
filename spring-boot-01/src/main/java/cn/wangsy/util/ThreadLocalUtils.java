package cn.wangsy.util;

/**
 * Created by wangsy on 2021/7/14
 */
public class ThreadLocalUtils {


    public static final ThreadLocal<Integer> localA = new ThreadLocal<>();
    public static final ThreadLocal<String> localB = new ThreadLocal<>();



    public static Integer getA(){
        return localA.get();

    }


    public static String getB(){
        return localB.get();
    }


    public static void set1Ab(Integer a, String b){
        localA.set(a);
        localB.set(b);
    }

    public static void removeAb(){
        localA.remove();
        localB.remove();
    }


}
