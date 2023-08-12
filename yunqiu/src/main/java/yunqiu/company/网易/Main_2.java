package yunqiu.company.网易;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main_2 {
    public static void main(String[] args) {
        Work works[] = {
                new Work(2,1,new int[]{5} ),
                new Work(3,1,new int[]{5}),
                new Work(4,1,new int[]{5}),
                new Work(5,1,new int[]{6}),
                new Work(5,1,new int[]{1})
        };
        solution(works,5,5);

    }
    public static void solution(Work works[],int voterNum,int candidateNum ){
        //获得投1的人数
        int index = 0;
        //temp用来存 [投给谁index--投票人数-- 贿赂所需金额] ，i坐标表示第i+1位选手
        Work temp[] = new Work[candidateNum];
        //初始化
        for(int i = 0;i<candidateNum;i++){
            temp[i] = new Work(i+1,0,new int[]{0});
        }
        //统计票数 即谁得了几票
        for(int i = 0;i< candidateNum;i++){
            for(int j = 0;j<works.length;j++) {
                //如果当前work的index - 1 = i
                if(works[j].getIndex() - 1 == i){
                   temp[i] = new Work(i+1,temp[i].getNum()+1,temp[i].getSorce());

                }
            }

        }
        //糖果排序
        int numOf1 = temp[0].getNum();
        int res = 0;
        Arrays.sort(temp);
        for(int i = 1;i<=voterNum;i++){
            int costNum = 0;
            List<Integer> costTempList = new ArrayList<>();
            //需要多少票
            int needVote = i - numOf1;
            //准备统计票数>=i的
            for(int k = 0;k<temp.length;k++){
                if(temp[k].getNum()>=numOf1){
                    int tem = temp[i].getNum() - i + 1;
                    for(int m = 0;m<tem;k++){
                        int [] nums = temp[k].getSorce();
                        costTempList.add(nums[m]);
                    }
                }
            }
            for(int j = 0;j<costTempList.size();j++){
                needVote--;
                costNum += costTempList.get(j);
            }
            if(needVote<=0){
                res = Math.min(res,costNum);
                continue;
            }
            // 光操作≥i选票的还不行，在剩下的人中继续抽
            costTempList = new ArrayList<>();

            for (int j = 1; j < candidateNum; j++) {
                // 准备统计票数≥i的剩下的部分
                if (temp[j].getNum() >= i) {
                    int tem = temp[j].getNum() - i + 1;
                    for (int k = tem; k < temp[j].getSorce().length; k++) {
                        int[] nums = temp[k].getSorce();
                        costTempList.add(nums[k]);
                    }
                } else {
                    // 票数没超过i的
                    int nums[] = temp[j].getSorce();
//                    costTempList.addAll(Arrays.asList(nums));
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
    static class Work {
        int index;
        int num;
        int[] sorce;

        public Work(int index, int num, int[] sorce) {
            this.index = index;
            this.num = num;
            this.sorce = sorce;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int[] getSorce() {
            return sorce;
        }
    }
}

