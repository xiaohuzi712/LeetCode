package LeetCode;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huchao on 2017/4/10.
 *输入字符串，返回无重复子串的最大长度
 * eg
 * Given "abcabcbb", the answer is "abc", which the length is 3.
   Given "bbbbb", the answer is "b", with the length of 1.
 */
public class Code3 {
    public Code3(){
    }
    //效率太低，时间复杂度为O(n2)
    public int lengthOfLongestSubstring1(String s) {
        int len = s.length();
        int max = 0;
        int[] counter = new int[len];
        for (int i = 0; i <len ; i++) {
            int sonLength = 1;
            Map<Character,Integer> map = new HashMap<Character,Integer>();
            char temp1 = s.charAt(i);
            map.put(temp1,i);
            for (int k = i+1; k <len ; k++) {
                char temp2 = s.charAt(k);
                if(map.containsKey(temp2)){
                   break;
                }else{
                    map.put(temp2,k);
                    sonLength++;
                }
            }
            counter[i] = sonLength;
        }
        for (int m = 0; m<counter.length ; m++) {
            if(counter[m]>max){
                max = counter[m];
            }
        }
        return max;
    }
    //改良版，HashMap太重要了，不允许Key相同
    public int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        if (len ==0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int max = 0;
        for (int i = 0,j=0; i <len; i++) {
            if(map.containsKey(s.charAt(i))){
                //记录第一次出现重复元素的位置
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max= Math.max(max,i-j+1);
        }
        return max;
    }
    public static void main(String[] args) {
        String str = "abcabcdb";
        Code3 code = new Code3();
        int result =code.lengthOfLongestSubstring2(str);
        System.out.println(result);
    }
}
