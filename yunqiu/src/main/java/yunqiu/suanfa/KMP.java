package yunqiu.suanfa;

import java.util.Collections;

public class KMP {
    //next[j] = k 表示p[j] 之前的模式串子串中，有长度为k的相同前缀和后缀。
    public static int[] Getnext(String pattern){
        int next[] = new int[pattern.length()];
        next[0] = -1;
        int k = -1;  //前缀索引坐标的初始化
        int j = 0;  //后缀索引坐标的初始化
        while (j < pattern.length()-1){
            //p[k]表示前缀，p[j]表示后缀
            //若p[k] == p[j]，则next[j + 1 ] = next [j] + 1 = k + 1；
            if(k == -1 || pattern.charAt(j) == pattern.charAt(k)){
                next[++j] = ++k;
            }else {
                //否则继续递归前缀索引k = next[k]
                k = next[k];
            }
        }
        return next;
    }
    public  static int KMPSearch(String str,String pattern){
        int strIndex = 0;
        int patternIndex = 0;
        int [] next = Getnext(pattern);
        while(strIndex <str.length() && patternIndex < pattern.length()){
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if(patternIndex == -1 || str.charAt(strIndex) == pattern.charAt(patternIndex)){
                strIndex++;
                patternIndex++;
            }else{
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                patternIndex = next[patternIndex];
            }
        }
        if(patternIndex == pattern.length()){
            return strIndex - patternIndex;
        }else
            return -1;
    }
//    private static int[] getNextArray(char[] chs) {
//        int i;//字符数组的下表指示器
//        int k;//前一个字符处的最大公共（相等）前、后缀子串的长度
//        int[] next = new int[chs.length];
//        for(i = 1,k = 0; i < chs.length; i++){
//            while(k > 0 && chs[i] != chs[k]) //如果下一个不同，那么k就变成next[k-1]
//                k = next[k - 1]; //往前回溯
//            if(chs[i] == chs[k]){ //如果相同，k加1
//                k++;
//            }
//            next[i] = k;//得到i位置的最大前缀和最大后缀相同的长度
//        }
//        return next;
//    }
    public static void main(String[] args) {
        String str = "BBCABCDAB";
        String pattern = "ABCDABD";
        System.out.println(KMPSearch(str,pattern));
    }
}
