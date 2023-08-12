package company.zijie.zrjie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 在一个交通非常便捷的城市，总共有n座建筑，建筑有A和B两种类型，建筑之间存在m条相互连通的双向道路，任意两个城市之间可以直接或间接地通过道路相互到达，经过长时间的调研市长发现建筑之间的通道过多导致维护成本远高于收益，因此决定尽可能多地停用一些道路，
 * 停用道路之后，城市之间仍然要保持便捷的交通，最终决定剩余的道路应满足以下要求:
 *      1.  n个建筑之间仍然可以直接或间接地相互到达
 *      2. 同类型的建筑之间不能直接到达，即A类建筑只能直接到达B类建筑，B类建筑只能直接到达A类建筑;
 *      3. 在满足以上条件的前提下，停用道路的数量应尽可能多，
 * 现在将规划的任务交给你，请给出个合理的方案。
 * 输入描述:
 *    第一行为两个整数n和m,表示有n座建筑和m条道路，第二行为一个长度为n的字符串，字符串只包含A和B，第i位字母表示第i座建筑
 *    的类型，接下去m行每行两个整数u,v，表示u座建筑和v座建筑之间有一条道路可以直接到达。
 * 输出描述：
 *    第一行为一个整数k,表示要继续运营的道路的数量，第二行为k个整数，每个整数表示一个道路的编号，道路按照输入顺序从1开始编号。如果有多解输出任意一个即可，注意输入的编号必须在区间[1,m]
 *    内，两两互不相等
 *输入：
 *      4   6
 *      AABB
 *      3   4
 *      2   1
 *      4   2
 *      3   1
 *      1   4
 *      2   3
 * 输出：
 *      3
 *      5   3   4
 *
 */
public class Main_4 {
    public static void main(String[] args) {
        Scanner sr   = new Scanner(System.in);
        int n = sr.nextInt();
        int m = sr.nextInt();
        String str = sr.next();
        char[] city = str.toCharArray();
        int map[][] = new int[m][2];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<2;j++){
                map[i][j] = sr.nextInt();
            }
        }

        //构造邻接矩阵
        int [][]arr = new int[n][n];
        for(int i = 0;i<m;i++){
                //同类型的建筑之间不能直接到达，置为0，否则置为1
                if( city[map[i][0]-1] != city[map[i][1]-1] )
                     arr[map[i][0]-1][map[i][1]-1] = 1;
        }
        //变成八皇后问题

    }

    private static void solution(int[][] map, int[][] arr) {
        List<int[]> list = new ArrayList<>();
        //选择第一条道路
        for(int i = 0;i<map.length;i++){
           if(arr[0][i]!=0){
               System.out.println(i+1);
               list.add(new int[]{0,i+1});
           }
        }
        //找出其他路


    }

}
