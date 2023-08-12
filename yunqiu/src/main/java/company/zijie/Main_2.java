package company.zijie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 寻找最小长方形
 * 题目：给定一系列2维平面点的坐标(x, y),其中x和y均为整数，要求用个最小的长方形框将所有点框在内。
 *      长方形框的边分别平行于x和y坐标轴，点落在边上也算是被框在内。
 * 输入描述：
 *      测试输入包含若干测试用例，每个测试用例由一系列坐标组成，每对坐标占一行，其中|x|和|y|小于231; - -对0坐标标志着一个测试田例的结束。
 *      注意（0，0）不作为任何一个测试用例里面的点。一个没有点的测试用例标志着整个输入的结束
 * 输出描述：
 *      对没个测试用例，在1行内输出2对整数，其间用一个空格隔开，第一对表示长方形左下角的坐标，第2对表示长方形右上角的坐标。
 * 示例：
 *   输入：
 *      12  56
 *      23  56
 *      13  10
 *      0    0
 *      12   34
 *      0    0
 *      0    0
 *   输出：
 *
 */
public class Main_2 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        List<List<int[]>> list=new ArrayList<>();
        ArrayList<ArrayList<Integer>> listxx = new ArrayList<>();
        ArrayList<ArrayList<Integer>> listyy = new ArrayList<>();
        while (true){
            ArrayList<Integer> listx = new ArrayList<>();
            ArrayList<Integer> listy = new ArrayList<>();
            while (true){
                int x=sr.nextInt();
                int y=sr.nextInt();
                listx.add(x);
                listy.add(y);
                if(x==0&&y==0){
                    listxx.add(listx);
                    listyy.add(listy);
                    break;
                }
            }
            if( listxx.get(listxx.size()-1).size()==1
                    && (listxx.get(listxx.size()-1).get(0)==0 && listyy.get(listyy.size()-1).get(0)==0) &&
                        (listxx.get(listxx.size()-2).get(listxx.get(listxx.size()-2).size()-1)==0
                            &&listyy.get(listyy.size()-2).get(listyy.get(listxx.size()-2).size()-1)==0))
                    break;
        }
        for(int i = 0;i<listxx.size();i++){
            listxx.get(i).remove(listxx.get(i).size()-1);
            listyy.get(i).remove(listyy.get(i).size()-1);
        }
        for(int i = 0;i<list.size()-1;i++){
            solution(listxx.get(i),listyy.get(i));
        }

    }
    private static void solution(ArrayList<Integer> listx, ArrayList<Integer> listy) {
        Collections.sort(listx);
        Collections.sort(listy);
        int min_x = listx.get(0);
        int min_y = listy.get(0);
        int max_x = listx.get(listx.size()-1);
        int max_y = listy.get(listy.size()-1);
        System.out.println(min_x +" "+ min_y + " " + max_x +" "+ max_y);
    }

}
