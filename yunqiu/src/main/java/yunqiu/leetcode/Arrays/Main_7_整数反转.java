package yunqiu.leetcode.Arrays;
/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 *         如果反转后整数超过 32 位的有符号整数的范围?[?231,? 231?? 1] ，就返回 0。
 *
 *         假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/reverse-integer
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main_7_整数反转 {
    public static int reverse(int x) {
        int res = 0;
        while (x!=0){
            //得到最后一位
            int pop = x%10;
            //得到前几位
            x = x/10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                res = 0;
                break;
            } else if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                res = 0;
                break;
            }
            res = res*10 + pop;

        }
        return res;
    }
        public static void main(String[] args) {
            System.out.println(reverse(-1234));
        }
}
