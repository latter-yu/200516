package Test;

import java.util.*;

public class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        //1.统计每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String x : words) {
            //遍历的简便写法
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        //2.把 map 中的所有 key 放到一个 ArrayList 中（相当于去重）
        List<String> result = new ArrayList<>(map.keySet());
        //3.排序(直接调用标准库)
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //在这个匿名内部类里，可以访问到上面的 map 变量
                //变量捕获
                int count1 = map.get(o1);
                int count2 = map.get(o2);
                if (count1 == count2) {
                    return o1.compareTo(o2);
                }
                return count2 - count1;
            }
        });
        //4.根据 k 的值，取出前 k 个元素
        return result.subList(0, k);
    }
}
