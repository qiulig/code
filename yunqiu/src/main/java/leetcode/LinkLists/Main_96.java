package leetcode.LinkLists;

public class Main_96 {
    public static int numTrees(int n) {
        //n个节点存在二叉树的个数
        long[] dp = new long[n + 1];
        //以i为根节点的二叉树个数
        dp[0] = 1; //以0为根节点的
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * (4 * i - 2) / (i + 1);
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(19));
    }
}
