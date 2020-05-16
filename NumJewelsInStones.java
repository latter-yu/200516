package Test;

import java.util.HashSet;
import java.util.Set;

public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        //宝石与石头：
        //给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 
        // S 中每个字符代表了一种所拥有的石头的类型，拥有的石头中有多少是宝石。
        //J 中的字母不重复，J 和 S中的所有字符都是字母。
        // 字母区分大小写，因此"a"和"A"是不同类型的石头。

        //1. 先把 J 中字符转入 Set 中
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        //2. 再遍历 S, 判断 S 中的字符是否在 Set 中存在
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
