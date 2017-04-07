package LeetCode;

/**
 * Created by huchao on 2016/11/18.
 */
public class Index {
    public  Index(){}

    public static void main(String[] args) {
        StringBuilder strb = new StringBuilder("初始化X");
        char[] value = new char[10];
        System.out.println(strb.capacity());
        System.out.println(strb.length());
        strb.append("你好呀啊哈哈哈XXXYYYZZZW");
        System.out.println(strb.reverse().toString());
        System.out.println(strb.length());
        //if(recentCapicty<length+新添加字符串长度) capicaty=recentCapicty*2+2
        System.out.println(strb.capacity());
    }
}
