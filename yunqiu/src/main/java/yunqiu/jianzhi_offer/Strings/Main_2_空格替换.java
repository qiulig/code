package yunqiu.jianzhi_offer.Strings;

/** 空格替换
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Main_2_空格替换 {
    public static class Solution {
        public static String replaceSpace(StringBuffer str) {
            return str.toString().replaceAll(" ", "%20");
        }

        public static void main(String[] args) {
            StringBuffer s =new StringBuffer("we are happy");
            System.out.println(replaceSpace(s));
        }
        public String replaceSpace2(StringBuffer str) {
                int spacenum = 0;//spacenum为计算空格数
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i)==' ')
                        spacenum++;
                }
                //indexold为为替换前的str下标
                int indexold = str.length()-1;
                //计算空格转换成%20之后的str长度
                int newlength = str.length() + spacenum*2;
                //indexold为为把空格替换为%20后的str下标
                int indexnew = newlength-1;
                //使str的长度扩大到转换成%20之后的长度,防止下标越界
                str.setLength(newlength);
                for(;indexold>=0 && indexold<newlength;--indexold){
                    if(str.charAt(indexold) == ' '){
                        str.setCharAt(indexnew--, '0');
                        str.setCharAt(indexnew--, '2');
                        str.setCharAt(indexnew--, '%');
                    }else{
                        str.setCharAt(indexnew--, str.charAt(indexold));
                    }
                }
                return str.toString();
            }
        }

}
