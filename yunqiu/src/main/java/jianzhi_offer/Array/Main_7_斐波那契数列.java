package jianzhi_offer.Array;

/**
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����
 * 1  1  2  3  5  8  13  21
 * n<=39
 */
public class Main_7_쳲��������� {
    public static class Solution {
        public static int Fibonacci(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1 || n == 2) {
                return 1;
            }
            int first = 1;
            int second = 1;
            int res = 0;
            for (int i = 3; i <= n; i++) {
                res = first + second;
                first = second;
                second = res;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.Fibonacci(7));
    }
}
