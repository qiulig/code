package leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * 55.��Ծ��Ϸ
 */
public class Main_55_jump_game {
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return true;
        //��������ľ���
        int maxDis = nums[0];
        //�ӵ�һ����ʼ������ֱ�������ڶ���������Ϊ���һ�����ǲ���������
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
