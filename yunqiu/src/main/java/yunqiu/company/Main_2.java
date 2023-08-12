package yunqiu.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main_2 {
    public static void main(String[] args) {
        solution(423234);
        solution2(4322234);
    }
    public static void solution(long a) {
        //存放出现一次的数
        List<Integer> list1 = new ArrayList<>();
        //存放重复的数
        List<Integer> list2 = new ArrayList<>();
        while (a != 0) {
            int temp = (int)a % 10;
            if (!list1.contains(temp) && !list2.contains(temp)) {
                list1.add(temp);
            } else {
                list1.remove(Integer.valueOf(temp));
                list2.add(temp);
            }
            a = a / 10;
        }
        //实现Comparator,将优先队列从大到小排列
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i = 0;i<list1.size();i++){
            queue.add(list1.get(i));
        }
        for(int i = 0;i<list2.size();i++){
            queue.add(list2.get(i));
        }
        long res = 0;
        while (queue.size()!=0){
            res = res*10 + queue.poll();
        }
        System.out.println(res);
    }
    public static void solution2(long a){
        //利用桶计数方法，判断哪个值出现过
        int count[] = new int[10];
        //用来计数，如果前面出现了0-9的所有数，则提前结束循环
        List<Integer> list = new ArrayList<>();
        while (a!=0){
            int temp =(int) a%10;
            count[temp]++;
            //list里面存放没出现的值
            if(!list.contains(temp)){
                list.add(temp);
            }
            //判断是否提前结束循环
            if(list.size() == 10){
                break;
            }
            a = a / 10;
        }
        //结果的生成
        long res = 0;
        for(int i = count.length-1;i>=0;i--){
            if(count[i]!=0){
                res = res*10 + i;
            }
        }
        System.out.println(res);
    }


}
