package leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 45.跳跃游戏ii
 */
public class Main_45_jump_game_ii {
    public static int jump(int[] nums) {
        //能跳的边界
        int end = 0;
        //能跳的最大范围
        int maxPostion = 0;
        //跳跃的次数
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPostion = Math.max(maxPostion, nums[i] + i);
            //起跳是否到达了前一次起跳的边界
            if (i == end) {
                //再次起跳
                steps++;
                //更新边界
                end = maxPostion;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
