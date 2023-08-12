package jianzhi_offer.Array;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Main_48_不用加减乘除做加法 {
    public static int Add(int num1,int num2) {
        int carry = 0;
        int sum = 0;
        do{
            //异或，相同为0不同为1 ,得到的结果相当于二进制的两个数无进位相加，相加为2的结果是0
            //如6和12相异或，即（0110^1100） = 1010
            sum = num1 ^ num2;
            //num1&num2得到该位数需要进位，即向前进位>>1
            carry = (num1&num2)<<1;
            num1 = sum;
            num2 = carry;
        }while(num2!=0);  //直到无进位结束
        return num1;
    }

    public static void main(String[] args) {
        System.out.println( Add(6,12));
    }
}
