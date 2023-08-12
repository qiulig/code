package yunqiu.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;
/**
* https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
* 3、无重复字符的最长子串
* 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
* */
public class Main_3_longest_substring_without_repeating_characters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap();
        char[] chars = s.toCharArray();
        int max = 0;
        //不重复的字符索引
        int left = 0;
        for(int i = 0;i<chars.length;i++){
            if(map.containsKey(s.charAt(i))){
                //重置最左的位置
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            //不存在则放入，存在则覆盖当前的索引
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);


        }
        return max;
    }
}
