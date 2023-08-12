package yunqiu.company.爱奇艺;
import java.util.*;
//贪心算法的区间调度问题
public class Main_3 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        int N = sr.nextInt();
        List<Work> lists = new ArrayList<>();
        for(int i = 0;i<N;i++){
            int x1 = sr.nextInt();
            int x2 = sr.nextInt();
            if(x1<x2)
                lists.add(new Work(x1,x2));
            else
                lists.add(new Work(x2,x1));
        }
        System.out.println(solution(lists));
}
    private static int solution(List<Work> works) {
        //works里面已经按end从小到大排序了
        Collections.sort(works);
        int count = 1;
        //当前工作的结束时间
        int endTime = works.get(0).getEnd();
        for(int i = 1;i<works.size();i++){
            if(endTime<=works.get(i).getStart()){
                count++;
                endTime = works.get(i).getEnd();
            }
        }
        return count;
    }

    static class Work implements Comparable{
    private int start;
    private int end;
    public Work(int start, int end) {
        this.start = start;
        this.end = end;
    }
    //end 从小到大排序
    @Override
    public int compareTo(Object o) {
        Work work = (Work) o;
        if(this.end > work.getEnd()){
            return 1;
        }else if(this.end == work.getEnd()){
            return 0;
        }else{
            return -1;
        }
    }
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }



}

}
