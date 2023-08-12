package yunqiu.leetcode.Arrays;

/**
 * 丑数
 * 编写一个程序，找出第 n 个丑数。
 丑数就是只包含质因数 2, 3, 5 的正整数。
 示例:
 输入: n = 10
 输出: 12
 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 说明:
 1 是丑数。
 n 不超过1690。
 */
public class Main_264 {
    public static int nthUglyNumber(int n) {
        int [] arr = new int[n];
        if(n==0)
            return 0;
        arr[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        for(int i = 1;i<n;i++){
            arr[i] =Math.min(Math.min(arr[t2]*2,arr[t3]*3),arr[t5]*5);
            if(arr[t2]*2 == arr[i]){
                t2++;
            }
            if(arr[t3]*3 == arr[i]){
                t3++;
            }
            if(arr[t5]*5 == arr[i]){
                t5++;
            }
        }
        return arr[n-1];
    }

    public static void main(String[] args) {
        nthUglyNumber(10);
    }
}
