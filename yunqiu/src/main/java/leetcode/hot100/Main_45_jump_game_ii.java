package leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 45.��Ծ��Ϸii
 */
public class Main_45_jump_game_ii {
    public static int jump(int[] nums) {
        //�����ı߽�
        int end = 0;
        //���������Χ
        int maxPostion = 0;
        //��Ծ�Ĵ���
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPostion = Math.max(maxPostion, nums[i] + i);
            //�����Ƿ񵽴���ǰһ�������ı߽�
            if (i == end) {
                //�ٴ�����
                steps++;
                //���±߽�
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
