package jianzhi_offer.Array;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Main_53_表示数值的字符串 {
    public static boolean isNumeric(char[] str) {
        String ss = String.valueOf(str);
        int len = ss.length();
        //先判断每个字符是否合法
        for(int i=0; i<len; i++){
            char c = ss.charAt(i);
            if(!((c>='0' && c <= '9') || c=='e' || c=='E'
                    || c=='+' || c=='-'|| c=='.'))
                return false;
        }
        ////正负号,E不能在末尾
        if(ss.charAt(len-1) == '+' || ss.charAt(len-1) == '-'
                || ss.charAt(len-1) == 'E' || ss.charAt(len-1) == 'e')
            return false;
        //判断小数点，只能有一个
        if(ss.indexOf(".") != ss.lastIndexOf("."))
            return false;
        //正负号在中间的位置时，前面的是e，E,后面是数字
        for(int i=1; i<len-1; i++){
            char c = ss.charAt(i);
            if(c == '+' || c=='-'){
                if(!(ss.charAt(i-1) == 'e' || ss.charAt(i-1) == 'E')
                        ||!(ss.charAt(i+1)>='0' && ss.charAt(i+1)<='9'))
                    return false;
            }
        }
        ////e的后面不能有数字12E+4.3
        for(int i=1; i<len; i++){
            char c = ss.charAt(i);
            if(c == 'e' || c=='E'){
                if(i==len-1)
                    return false;
                if(ss.charAt(i+1) == '+' || ss.charAt(i+1) == '-'){
                    //从i+2开始往后没有小数点.则返回-1
                    if(ss.indexOf(".", i+2) != -1){
                        return false;
                    }
                }else{
                    if(ss.indexOf(".", i+1) != -1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char []str = {'+','1','e','.','3'};
        System.out.println(isNumeric(str));
    }
}
