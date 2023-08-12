package yunqiu.jianzhi_offer.Array;

/**
 * 跳台阶：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Main_8_跳台阶 {
    public class Solution {
        public int JumpFloor(int target) {
            if(target<=2)
            {
                return target;
            }
            int one_=1; //第一次跳台阶的方法数
            int two_=2; //第二次跳台阶的方法数
            int finN=0;
            for(int i=3;i<=target;i++)
            {
                finN=one_+two_;
                one_=two_;
                two_=finN;
            }
            return finN;
        }
    }
}
