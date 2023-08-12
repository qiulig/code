package jianzhi_offer.Array;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,
 * 想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”
 * 不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,
 * 然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class Main_45_扑克牌的顺子 {
    /**
     * 组成顺子的条件是：
     * (1) 数组长度为5
     * (2)数组中数不重复
     * (3)最大值Max减最小值Min<5,其中Max和Min不能为0,即不包括大小王的最大值最小值
     */
    public static boolean isContinuous(int [] numbers) {
        if(numbers.length<5)
            return false;
        int Max = Integer.MIN_VALUE;
        int Min = Integer.MAX_VALUE;
        int count[] = new int[14];
        //除0以外没有重复的数
        for(int i = 0;i<numbers.length;i++){
            count[numbers[i]]++;
            //如果是大小王的话，可以允许多个，直接continue不执行count[numbers[i]>=2的判断
            if(numbers[i] == 0){
                continue;
            }
            if(count[numbers[i]]>=2){
                return false;
            }
            //
            if(Max<numbers[i]) {
                Max = numbers[i];
            }
            if(Min >numbers[i]){
                Min = numbers[i];
            }
        }
        if ( Max - Min < 5) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int numbers[] = {0,2,3,4,6};
        System.out.println(isContinuous(numbers));
    }
}
