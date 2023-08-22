package jianzhi_offer.Array;

public class Main_12_数值的整数次方 {
    public static class Solution {
        public static double Power(double base, int exponent) {

            if (exponent < 0) {
                return powCal(1.0 / base, -1 * exponent);
            } else if (exponent > 0) {
                return powCal(base, exponent);
            } else {
                return 1;
            }
        }

        private static double powCal(double base, int exponent) {
            double res = 1;
            for (int i = 0; i < exponent; i++) {
                res = res * base;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.Power(2, -3));
    }
}
