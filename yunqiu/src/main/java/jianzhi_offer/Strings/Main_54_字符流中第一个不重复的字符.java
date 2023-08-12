package jianzhi_offer.Strings;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，
 * 第一个只出现一次的字符是"l"。
 */
public class Main_54_字符流中第一个不重复的字符 {
    //源源不断的有字母放到字符串中，建立一个256个大小的int型数组来代表哈希表
    public class Solution {
        String str="";
        int[] count=new int[256];
        public void Insert(char ch)
        {
            if(ch >=256){
                return ;
            }else{
                str+=ch;//字符放入字符串
                count[ch]++;//根据字符，修改数组字符元素的值
            }
        }
        public char FirstAppearingOnce()
        {
            for(char c:str.toCharArray()){// //注意的是，要找第一个出现一次的字符，所以遍历字符串，不能遍历哈希数组
                if(count[c]==1){//如果字符串作为下表的元素值为1，说明该字符出现一次，直接返回该字符
                    return c;
                }
            }
            return '#';
        }
    }
}
