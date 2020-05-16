package Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BadKeyboard {
    public static void main(String[] args) {
        //旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。
        // 给出应该输入的一段文字、以及实际被输入的文字，列出肯定坏掉的那些键。
        //应该输入：7_This_is_a_test (<br/> => 换行的意思)
        //实际输入：_hs_s_a_es
        //输出确定的坏键：7TI
        //推出：1.最终输出的一定是大写字母;
        //     2.坏键则大小写字母都无法输出.

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //1.处理输入, 读取输入字符串
            String expected = sc.next();
            String actual = sc.next();
            //2.把两个字符串都转成大写
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            //3.把 actual(实际输入) 中的字符放到一个 set 中
            Set<Character> setActual = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                setActual.add(actual.charAt(i));
            }
            //4.遍历预期输出的字符串，没有在 setActual 出现的字符就是坏键
            Set<Character> brokenKey = new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c= expected.charAt(i);
                if (setActual.contains(c)) {
                    //存在就不是坏键
                    continue;
                }
                //防止坏键输出重复
                if (brokenKey.contains(c)) {
                    continue;
                }
                System.out.print(c);
                brokenKey.add(c);
            }
            System.out.println();
        }
    }
}
