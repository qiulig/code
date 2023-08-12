package yunqiu.suanfa;

public class kmp1 {
    public int KMPSearch(String str, String pattern)
    {
        int strIndex = 0;
        int patternIndex = 0;
        int [] next = GetNext(pattern);
        while (strIndex < str.length() && patternIndex  < pattern.length())
        {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (patternIndex  == -1 || str.charAt(strIndex) == pattern.charAt(patternIndex ))
            {
                strIndex++;
                patternIndex ++;
            }
            else
            {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                patternIndex  = next[patternIndex ];
            }
        }
        if (patternIndex  == pattern.length())
            return strIndex - patternIndex ;
        else
            return -1;
    }
    //next[j] = k 表示p[j] 之前的模式串子串中，有长度为k的相同前缀和后缀。
    public static int[] GetNext(String pattern){
        int next[] =new int[ pattern.length()];
        next[0] = -1;
        int k = -1;  //前缀的索引坐标初始化
        int j = 0;  //后缀的索引坐标初始化
        while (j<pattern.length()-1){
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
}
