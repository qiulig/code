package yunqiu.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;
/**
* https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
* 3�����ظ��ַ�����Ӵ�
* ����һ���ַ��� s �������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
* */
public class Main_3_longest_substring_without_repeating_characters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap();
        char[] chars = s.toCharArray();
        int max = 0;
        //���ظ����ַ�����
        int left = 0;
        for(int i = 0;i<chars.length;i++){
            if(map.containsKey(s.charAt(i))){
                //���������λ��
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            //����������룬�����򸲸ǵ�ǰ������
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);


        }
        return max;
    }
}
