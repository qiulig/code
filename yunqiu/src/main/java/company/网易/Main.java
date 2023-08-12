package company.网易;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author     ：
 * @date       ：2019/6/25 0025
 * @description:
 * 参考@XiaKIsGod的c版本，写了java版本。
 * 思路就是暴力枚举：
 * 这个哥们当选，至少得到k张票，分以下两种情况
 * 1.暗箱操作每个大于等于k的候选者多余的票，如果暗香操作完了，则continue，否则，转2；
 * 2.把剩下的所有没有被暗箱操作的票聚集起来，排个序，一个一个取，直到候选者的票大于等于k；
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 多少张票
        int voteNum = in.nextInt();
        // 多少个候选者
        int peopleNum = in.nextInt();
        // 每个候选者的票
        int[] voteNumOfPeople = new int[peopleNum];
        // 暗箱操作某个候选者的票消耗的糖果
        List<Integer>[] cost = new ArrayList[peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            cost[i] = new ArrayList<>();
        }//        List<List<Integer>> cost = new ArrayList<>();
        // 最后的结果
        long res = Integer.MAX_VALUE;
        // 读每张票，存入cost和voteNumOfPeople
        for (int i = 0; i < voteNum; i++) {
            int peopleTemp = in.nextInt() - 1;
            int costTemp = in.nextInt();
            voteNumOfPeople[peopleTemp]++;
            cost[peopleTemp].add(costTemp);
        }
        // 每个候选者暗香操作的糖果排序
        for (int i = 1; i < peopleNum; i++) {
            Collections.sort(cost[i]);
        }
        // 开始暴力枚举 这哥们至少i张票才能入选
        for (int i = 1; i <= voteNum; i++) {
            long costNum = 0;
            List<Integer> costTempList = new ArrayList<>();
            // 需要多少票
            int needVote = i - voteNumOfPeople[0];
            // 准备统计票数≥i的
            for (int j = 1; j < peopleNum; j++) {
                if (voteNumOfPeople[j] >= i) {
                    int temp = voteNumOfPeople[j] - i + 1;  //需要的票数差
                    for (int k = 0; k < temp; k++) {
                        costTempList.add(cost[j].get(k));
                    }
                }
            }
            for (int j = 0; j < costTempList.size(); j++) {
                needVote--;
                costNum += costTempList.get(j);
            }
            // 光削大头的就够了，就直接返回
            if (needVote <= 0) {
                res = Math.min(res, costNum);
                continue;
            }
            // 光操作≥i选票的还不行，在剩下的人中继续抽
            costTempList = new ArrayList<>();

            for (int j = 1; j < peopleNum; j++) {
                // 准备统计票数≥i的剩下的部分
                if (voteNumOfPeople[j] >= i) {
                    int temp = voteNumOfPeople[j] - i + 1;
                    for (int k = temp; k < cost[j].size(); k++) {
                        costTempList.add(cost[j].get(k));
                    }
                } else {
                    // 票数没超过i的
                    costTempList.addAll(cost[j]);
                }
            }
            Collections.sort(costTempList);
            // 票数不够继续补
            for (int j = 0; j < costTempList.size(); j++) {
                needVote--;
                costNum += costTempList.get(j);
                if (needVote <= 0) {
                    res = Math.min(costNum, res);
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
