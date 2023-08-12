package jianzhi_offer.Strings;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Main_27_字符串的排列 {
    public static class Solution {


        public static void main(String[] args) {
        String arr = "aa";
        Solution t = new Solution();
        ArrayList<String> list = new ArrayList<String>();
        list=t.Permutation(arr);
        for(int i = 0 ; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
        public static ArrayList<String> Permutation(String str) {
            ArrayList<String> res = new ArrayList<String>(); //用于排序输出
            if(str==null||str.length()==0){
                return res;
            }
            char[] chars = str.toCharArray();

            res=Permu(chars,0,res);

            return res ;
        }

        public static ArrayList<String> Permu(char[] str, int start, ArrayList<String> list) {
            if (str == null) {
                return null;
            }
            if (start == str.length - 1) {
                //去除重复的字符串
                if (list.contains(String.valueOf(str))) {
                    return null;
                }
                else{list.add(String.valueOf(str));}
            } else {

                for (int j = start; j < str.length; j++) {
                    swap(str,j,start);
                    Permu(str, start+ 1, list);
                    swap(str,j,start);
                }
            }
            Collections.sort(list);
            return list;
        }
        public static void swap(char[] chars,int a,int b){
            if(a==b){//因为会出现原位置与原位置交换，直接空即可

            }else{
                char temp = chars[a];
                chars[a]=chars[b];
                chars[b]=temp;
            }
        }

    }
}
