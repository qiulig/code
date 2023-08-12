package yunqiu.jianzhi_offer.Array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Main_34_第一个只出现一次的字符位置 {
    public static int FirstNotRepeatingChar(String str) {
        if (str.length() == 0 || str == null)
            return -1;
        ArrayList<Character> list1 = new ArrayList<Character>();//list1存放str中出现1次的字符
        ArrayList<Character> list2 = new ArrayList<Character>();//list2存放str中出现多次的字符
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //两个list里面都没有这个字符
            if (!list1.contains(ch) && !list2.contains(ch)) {
                //将字符放到list1中
                list1.add(Character.valueOf(ch));

            } else {
                //将list1之前加入的删掉（此时出现了相同字符，删掉相同字符）
                list1.remove(Character.valueOf(ch));
                //将str中含有的相同字符存入list2
                list2.add(Character.valueOf(ch));
            }
        }
        if (list1.size() < 0) {
            return -1;
        }
        return str.indexOf(list1.get(0));

    }

    public static void main(String[] args) {
        String str = "abdbcsrfncd";
        FirstNotRepeatingChar(str);
    }


}
