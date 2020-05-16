package Test;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次
        //找出那个只出现了一次的元素
        Map<Integer, Integer> map = new HashMap<>();
        // 1.统计每个数字出现的次数
        // key 表示具体的数字. value 表示该数字在数组中出现的次数
        for (int x : nums) {
            Integer count = map.get(x);
            if (count == null) {
                map.put(x, 1);
            }else {
                map.put(x, count + 1);
            }
        }

        // 2.遍历 Map, 找到只出现一次的数字
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    //普通方法具有线性时间复杂度，也可以不使用额外空间来实现
    public int singleNum(int[] nums) {
        //使用 异或 的性质
        //1. x ^ 0 = x
        //2. x ^ y ^ y = x
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
            //最后结果就是出现一次的数
        }
        return ret;
    }
}
