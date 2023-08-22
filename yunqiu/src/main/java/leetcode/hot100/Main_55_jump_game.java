package leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * 55.跳跃游戏
 */
public class Main_55_jump_game {
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return true;
        //最大能跳的距离
        int maxDis = nums[0];
        //从第一个开始遍历，直到倒数第二个数，因为最后一个数是不能起跳的
        for (int i = 0; i < len - 1; i++) {
            if (i <= maxDis) {
                maxDis = Math.max(maxDis, i + nums[i]);
            }
        }
        return maxDis >= len - 1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(canJump(nums));
    }
}
