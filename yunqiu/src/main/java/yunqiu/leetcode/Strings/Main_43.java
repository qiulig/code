package yunqiu.leetcode.Strings;

public class Main_43 {
    //leetcode43题：
    /**
     *  给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，
     *  它们的乘积也表示为字符串形式。
     */
        public static String multiply(String num1, String num2) {
            if(num1.length() == 1 && Integer.parseInt(num1) == 0) {
                return num1;
            }
            if(num2.length() == 1 && Integer.parseInt(num2) == 0) {
                return num2;
            }
            int[] nums = new int[num1.length() + num2.length()];
            String result = "";
            for (int i = 0; i < num1.length(); i++) {
                for (int j = 0; j < num2.length(); j++) {
                    nums[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                }
            }
            int flag = 0;
            for (int i = num1.length() + num2.length() - 2; i >= 0; i--) {
                result = (nums[i] + flag) % 10 + result;
                flag = (nums[i] + flag) / 10;
            }
            if(flag > 0) {
                result = flag + result;
            }
            return result;
        }

    public static void main(String[] args) {
        System.out.println(multiply("98","43"));
    }

   }
