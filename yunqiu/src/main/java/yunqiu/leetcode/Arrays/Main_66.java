package yunqiu.leetcode.Arrays;

public class Main_66 {
    public static int[] plusOne(int[] digits) {
        if(digits.length == 0 )
            return digits;
        int n = digits.length-1;
        if(digits[n]<9){
            digits[n] = digits[n]+1;
            return digits;
        }else{
            while(n>=0){
                if(digits[n]==9){
                    digits[n] = 0;
                    n--;
                }else{
                    digits[n] = digits[n] + 1;
                    break;
                }
            }
            if(digits[0] == 0){
                int res[] = new int[digits.length+1];
                res[0] = 1;
                for(int i = 1;i<res.length;i++){
                    res[i] = digits[i-1];
                }
                return res;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int arr[] = {9,6,9};
        int res[] = plusOne(arr);
        for(int i = 0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    }
}
