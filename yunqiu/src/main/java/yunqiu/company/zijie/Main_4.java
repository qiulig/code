package yunqiu.company.zijie;

import java.util.Scanner;

/**
 *
 *题目描述
     *   不死族的巫妖王一般会在月末会给死亡骑土发工资，而死亡骑士拿到工资(总是为一张N元的钞票，记住只有张钞票,为了防止下月自己在战斗中频繁的死掉他会给自己买一些道具，于是他来到了地精商店前
     *   死亡骑士"我要买道具!”
     *   地精商人:“我们这里有三种道具血瓶150块一个 魔法药200块一个无敌药水350块个.”
     *   死亡骑土:好的，给我一个血瓶”
     *   说完他掏出那张N元的大钞递给地精商人
     *   地精商人"我忘了提醒你了，我们这里没有找客人钱的习惯的，多的钱我们都当小费收了的，嘿嘿"”死亡骑士”.. ."
     *   死亡骑土想与其把钱当小费送个他还不如自己多买一点道具，反正以后都要买的，早点买了放在家里也好但是要尽量少让他赚小费现在死亡骑士遇到了难题，希望你能帮他计算一下 最少他要给地精商人多少小费。

 * 输入描述:
 *     输入数据的第一行是一个整数T(1<=7<=100), 代表测试数据的数量.然后是r行测试数据,每个测试数据只包含一个正整数N(1<=N<=10000) ,
 *     s代表死亡骑士手中钞票的面值. 注意:地精商店只有题中描述的三种道具.
 * 输出描述:
 *     对于每组测试数据,请你输出死亡骑士最少要浪费多少钱给地精商人作为小费
 * 示例：
 *    输入：
 *      2
 *      340
 *      900
 *   输出：
 *      40
 *      0
 */
public class Main_4 {
    public static int solution(int weight[],int value[],int f[],int num,int total){
        for(int i = 0;i<num;i++){
            for(int v = weight[i];v<=total;v++){
                f[v] = Math.max(f[v-weight[i]]+value[i],f[v]);
            }
        }
        return total - f[total];
    }
//350为150和200的和，所以可以不买350的，用150和200的药水代替即可，然后150和200又可以拆成150+0和150+50，首先看能买多少150的药水，然后可以在每瓶的基础
// 上加50元或者不加，这样就能留下最少的小费给地精商人
    public static int solution(int total){
        int sum = total;
        int s1 = sum / 150;  //能买多少个150的
        sum = sum % 150;  //剩余的钱
        //剩余的钱能买多少个50的，把药水可变成200的，如果剩余钱的/50的个数<买150药水的个数，
        //即药水可以变成200的或者原地还是买150的药水，剩余最少的钱就是把50的整数用完，即sum%50
        if(sum/50 <= s1){
            sum = sum % 50 ;
        }else{
            //把所有药水都变成200块钱的，即剩下的钱 - (150的药水的个数 * 50)
            sum = sum - (50 * s1);
        }
        return sum;
    }
    public static void main(String[] args) {
        int weight[] = {150,200,350};
        Scanner sr = new Scanner(System.in);
        int num  = sr.nextInt();
        int total[] = new int[num];
        for(int i = 0;i<num;i++){
            total[i] = sr.nextInt();
        }
        for(int i = 0;i<num;i++) {
            int f[] = new int[total[i] + 1];
//            System.out.println(solution(weight, weight, f, 3, total[i]));
            System.out.println(solution(total[i]));
        }

    }
}
