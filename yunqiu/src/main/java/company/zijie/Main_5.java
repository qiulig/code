package company.zijie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 ■题目描述
   “连连看相信很多人都玩过。没玩过也没关系，下面我给大家介绍一下游戏规则:在一个棋盘中，放了很多的棋子。如果某两个相同的棋子，可以通过一条线连起来
    (这条线不能经过其它棋子)，而且线的转折次数不超过两次，那么这两个棋子就可以在棋盘上消去。不好意思，由于我以前没有玩过连连看，咨询了同学的意见，连
    线不能从外面绕过去的，但事实上这是错的。现在已经酿成大祸，就只能将错就错了，连线不能从外围绕过。玩家鼠标先后点击两块棋子，试图将他们消去，然后游
    戏的后台判断这两个方格能不能消去。现在你的任务就是写这个后台程序。
 输入描述：
    输入数据有多组。每组数据的第1行有两个正整数n,m(0<n<=1000, 0<m<1000）,分别表示棋盘的行数与列数。在接下来的n行中，每行有m个非负整数描述棋盘的方格分
    布。0表示这个位置没有棋子，正整数表示棋子的类型。接下来的一行是个正整数q(0<q<50)， 表示下面有q次询问。在接下来的q行里，每行有四个正整数x1, y1, x2,
    y2,表示询问第x1行y1列的棋子与第x2行y2列的棋子能不能消去。n=0,m=0时，输入结束。
    注意:询问之间无先后关系，都是针对当前状态的!
 输出描述:
    每一组输入数据对应1行输出。如果能消去则输出"YES",不能则输出"NO"。
 输入：
    3   4
    1   2   3   4
    0   0   0   0
    4   3   2   1
    4
    1   1   3   4
    1   1   2   4
    1   1   3   3
    2   1   2   4
    0   0
 输出：
    YES
    NO
    NO
    NO
 */
public class Main_5 {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        Scanner sr = new Scanner(System.in);
        while (true) {
            int row = sr.nextInt();
            int col = sr.nextInt();
            if (row == 0 && col == 0) {
                break;
            } else {
                //存放消消乐图型
                int[][] map = new int[row][col];
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        map[i][j] = sr.nextInt();
                    }
                }
                int num = sr.nextInt();
                //用于存放需要消消乐的坐标，每个list里面有四个数，代表x1,y1,x2,y2
                ArrayList<ArrayList> lists = new ArrayList<>();
                for (int i = 0; i < num; i++) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int j = 0; j < 4; j++) {
                        list.add(sr.nextInt());
                    }
                    lists.add(list);
                }
                for (int i = 0; i < lists.size(); i++) {
                    int x1 = (int) lists.get(i).get(0) - 1;
                    int y1 = (int) lists.get(i).get(1) - 1;
                    int x2 = (int) lists.get(i).get(2) - 1;
                    int y2 = (int) lists.get(i).get(3) - 1;
                    if (map[x1][y1] != map[x2][y2] || (map[x1][y1] == 0 && map[x2][y2] == 0)) {
                        res.add("NO");
                        continue;
                    } else {
                        if (dfs(x1, y1, 0, 0) || dfs(x1, y1, 0, 1)
                                || dfs(x1, y1, 0, 2) || dfs(x1, y1, 0, 3)) {
                            res.add("YES");
                        } else {
                            res.add("NO");
                        }

                    }
                }
            }

        }
        //输出结果
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    private static boolean dfs(int x1, int y1, int turn, int direction) {
        if(turn>2)
            return false;
    return true;
    }


}
