package yunqiu.jianzhi_offer.Array;

/**正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Main_52_正则表达式匹配 {
//    public static boolean match(char[] input, char[] pattern) {
//        String str1 = input.toString();
//        String str2 =  pattern.toString();
//        if (input == null || pattern == null) return false;
//            return matchCore(str1, 0, str2, 0);
//    }
//
//    private static boolean matchCore(String str,int strIndex,String pattern,int patternIndex){
//        if((str.length()==strIndex)&&(pattern.length()==patternIndex)){
//            //出口1，input和pattern都到了字符串末尾
//            return true;
//        }
//        if((strIndex!=str.length())&&(pattern.length()==patternIndex)){
//             //出口2，字符串input没有到末尾，pattern到了末尾
//            return false;
//     }
//     if((str.length()==strIndex)&&(pattern.length()!=patternIndex)){
//             //出口3，字符串input到末尾，pattern还没有到末尾
//             return false;
//         }
//     // 情况1：pattern的第二个字符是*
//     if((patternIndex+1<pattern.length())&&(pattern.charAt(patternIndex+1)=='*')){//pattern第二个字符为*
//             if((str.charAt(strIndex)==pattern.charAt(patternIndex))||(pattern.charAt(patternIndex)=='.')){
//                     //首字母相匹配
//                     return matchCore(str,strIndex+1,pattern,patternIndex+2) //*匹配次
//                          ||matchCore(str,strIndex+1,pattern,patternIndex)    //*匹配多次
//                          ||matchCore(str,strIndex,pattern,patternIndex+2);   //*匹配0次
//                 }else{
//                     //首字母不匹配（’.’与任意字符视作匹配），那么’*’只能代表匹配0次
//                     return matchCore(str,strIndex,pattern,patternIndex+2);
//                 }
//         }
//     //情况2：patttern第二个字符不是’*‘时：
//     if((str.charAt(strIndex)==pattern.charAt(patternIndex))||(pattern.charAt(patternIndex)=='.')){
//             //pattern第二个字母不是*，且首字母匹配
//             return matchCore(str,strIndex+1,pattern,patternIndex+1);
//         }
//     return false;  //其余情况全部不匹配
// }
    public static boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null)
            return false;
        int strIndex = 0,patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }
    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;    }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        //   //如果当前pattern的下一个是*并且没有超出pattern的长度时
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            // //如果当前字符str[index]和pattern[index]相等，或者当前pattern为‘.’
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符(当前pattern[index+1]='*'且str[index]!=pattern[index]）
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符 (当前pattern[i+1]='*'且str[index]=pattern[index])
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个（当前pattern[index]='.'）
            } else {
                //当前字符str[index]和pattern[index]不相等&&当前pattern不为‘.’
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        //pattern[index]='.'的情况，strindex和pattern都加1向下匹配
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        char str[] = {'a','.','a','a','b'};
        char pa[] = {'a','.','*','b'};
        match(str,pa);
        int a=5;
        int b= 5;
        int c = a>>2+b>>2;
        System.out.println(c);
    }


}
