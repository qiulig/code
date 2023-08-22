package suanfa;

//跳一跳
//有n个盒子排成一行，每个盒子上面有一个数字a[i]，表示最多能向右跳a[i]个盒子；
//小明站在左边第一个盒子，请问能否到达最右边的盒子？
//        比如说：[1, 2, 3, 0, 4] 可以到达第5个盒子；
//        [3, 2, 1, 0, 4] 无法到达第5个盒子；
//解题思路：尽可能的往右跳，看最后是否能到达。
//同leetcode-55.跳跃游戏
public class Main_贪心_跳跃游戏 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 4};
        int[] arrs = {3, 2, 1, 0, 4};
        System.out.println(solution(arr));
    }

    //贪心算法
    private static boolean solution(int[] arr) {
        int lastPos = arr.length - 1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (i + arr[i] >= lastPos)
                lastPos = i;
        }
        return lastPos == 0;
    }

    //动态规划
    private static boolean canJump(int[] arr) {
        if (arr == null)
            return false;
        boolean[] dp = new boolean[arr.length];
        dp[0] = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                //如果之前的j节点可达，并且从此节点可以跳到i
                if (dp[j] == true && arr[j] + j >= i) {
                    dp[i] = true;
                }
            }
        }
        return dp[arr.length - 1] == true;
    }
}
