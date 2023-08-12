package company.vivo.L2019;

public class Main_3 {
    public static void main(String[] args) {
        String str = "abba";
        solution(str);
    }
    public static void solution(String str){
        char arr[] = str.toCharArray();
        //dp[i][j]代表i~j的字符串的回文长度
        boolean [][]dp = new boolean[str.length()][str.length()];
        //初始化对角线
        for(int i = 0;i<str.length();i++){
            dp[i][i] = true;
        }
        //初始化相邻的两个字符是否为回文
        for(int i = 0;i<=arr.length-2;i++){
            dp[i][i+1] = str.charAt(i) == str.charAt(i+1)?true:false;
        }
        int max = 1;
        String res = "";
        for(int i = 0;i<arr.length;i++){
            for(int j = i+2;j<arr.length;j++){
                    //两端的数相等以及中间的数是回文
                    dp[i][j] = dp[i+1][j-1] && str.charAt(i) == str.charAt(j) ? true:false;
                if(dp[i][j] == true && j - i + 1>max){
                    max = j-i+1;
                    res = str.substring(i,j+1);
                }
            }
        }
        System.out.println(max);
        System.out.println(res);
    }
}
