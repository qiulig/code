package yunqiu.jianzhi_offer.Array;

/** 把字符串转换成整数
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class Main_49_把字符串转换成整数 {
    public static int StrToInt(String str) {
        if(str.trim().equals("")){
            return 0;
        }
        int sum = 0;
        int flag = 1;
        if(str.charAt(0) =='+'||str.charAt(0)=='-'){
            if(str.charAt(0)=='-') {
                flag = -1;
            }
            sum = cal(str,1,str.length(),flag);
        }else{
            sum = cal(str,0,str.length(),flag);

        }
        return sum*flag;
    }
 //  Integer范围：-2147483648 ~ 2147483647。
    private static int cal(String str, int start, int end,int flag) {
        int sum = 0;
        for(int i = start;i<end;i++){
            if(str.charAt(i)>='0' &&str.charAt(i)<='9'){
                //正数
                if(flag == 1 && sum>Integer.MAX_VALUE)
                    throw new RuntimeException("上溢出");
                //负数
                if(flag == -1 && sum<Integer.MIN_VALUE)
                    throw new RuntimeException("下溢出");
                sum = sum*10+str.charAt(i)-'0';
            }else{
                return 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("+21474836488"));
        System.out.println(StrToInt("-2a4"));
    }

}
