package LeetCode;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by huchao on 2017/4/6.
 * 用于寻找数组中和为定值的元素索引12131232
 */
public class Code1 {
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        //使用两层循环，时间复杂度为O(n2)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target==nums[i] + nums[j] ) {
                    result[0] = i;
                    result[1] = j;
                    return  result;
                }
            }
        }
        return result;
    }
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //使用hashmap求解，提高速度
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
            public static void main(String[] args) {
                Code1 code = new Code1();
                int[] nums = {3,2,4};
                int [] result = code.twoSum2(nums, 6);
                for (int i = 0; i <result.length ; i++) {
                    System.out.println(result[i]);
                }
                System.out.println(result);
    }
}
