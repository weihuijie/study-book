package 数据结构.串;

/**
 * @author: whj
 * @date: 2023/11/8
 * @description
 */
public class 简单的模式匹配算法 {
    public static int index(char[] s,char[] t){
        int i=0;
        int j=0;
        while (i <= s.length -1 && j <= t.length-1) {
            if (s[i] == t[j]) {
                //继续比较后继字符
                ++i;
                ++j;
            } else {
                //指针后退重新开始匹配
                i = i - j + 1;
                j = 0;
            }
        }
        if (j>t.length - 1){
            return i-t.length;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        char[] s = {'a','b','c','c','d','e','f','c','c','d','e','f','g','g','g','g'};
        char[] t = {'d','e','f','g'};
        System.out.println(index(s,t));
        System.out.println(String.valueOf(s));
        System.out.println(String.valueOf(t));
        System.out.println(String.valueOf(s).indexOf(String.valueOf(t)));
    }
}
