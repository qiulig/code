package company.zijie.zrjie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 *在一个树形的网络结构中，总共有n个节点，它们在传输教据的过程中会产生各种延时，如节点处理时延、排队时延、传输时延、传播甜延等，我们将所有传输过程中产生的时延求和取均值统一为一个数值。
 *为估计整个网络的效率，现在需要抽取某些网络节点，并计算在所有可能传输到的其他节点中，最长的总时延，如节点A到节点B的时延为x毫秒，节点B到节点C的时延为y毫秒，则节点A到节点C的总时延为x+y毫秒，由于网络中存在大量的节点以及多次的抽样，你的程序需要用尽可能高效的方式运行以得到结果。
 *输入描述:
 *       第一行一个整数n,接下去n-1行每行三个整数u,v,w,表节点u与节点v之间的时延为w,
 *      第 n+1 行为一个整数q,表示有q次抽样，接下去q行每行一个整数pos,表示被询间的节点编号。
 * 输出描述:
 *     对于每个被抽样的节点，输出该节点到网络中所有其他节点的最大总时延。
 *示例1
 *   输入
 *   4
 *   1  2   10
 *   1  3   5
 *   4  1   3
 *   2
 *   2
 *   4
 *   输出：
 *   15
 *   13

 */
public class Main_5 {
    public static void main(String[] args) {
        Scanner sr   = new Scanner(System.in);
        int n = sr.nextInt();

        List<pos> list = new ArrayList<>();
        for(int i = 0;i< n-1;i++){
            list.add(new pos(sr.nextInt(),sr.nextInt(),sr.nextInt()));
        }
        //获取距离矩阵
        int arr[][] = new int[n][n];
        for(int i = 0;i< list.size();i++){
                arr[list.get(i).getX()-1][list.get(i).getY()-1] = list.get(i).getDistance();
                arr[list.get(i).getY()-1][list.get(i).getX()-1] = list.get(i).getDistance();
        }

        int q = sr.nextInt();
        int []pos = new int[q];
        for(int i = 0;i<q;i++){
            pos[i]  = sr.nextInt();
        }
    }
    public static void solution(int arr[][]){

    }
    static class pos{
        int x;
        int y;
        int distance;

        public pos(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
}
