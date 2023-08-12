package company.百度;

import java.text.DecimalFormat;
import java.util.Arrays;
public class Main_1 {
    public static void main(String[] args) {
        int a[] = {1,7,3,4,5,9};
        int b[] = {2,3,9,4,3,3};
//        System.out.println(String.format("%.2f",solution(a,b)));
        solution(a,b);
    }
    public static void solution(int A[],int B[]){
        Diff []list= new Diff[A.length];
        for(int i = 0;i<A.length;i++){
            list[i] = new Diff(i,A[i] - B[i]);
        }
        //里面的list已经(a-b)从小到大排序了
        Arrays.sort(list);
        double res = 0;
        //取值,较小的去2连，中间的去三连，较大的去1连
        int Avglen = list.length/3;

        for(int i = 0;i<list.length;i++){
            if(0<=i && i<Avglen ){
                res += B[list[i].index];
            }else if(i >= Avglen && i< 2 *Avglen ){
                res += ((A[list[i].index] + B[list[i].index])*1.0)/2;
            }else{
                res += A[list[i].index];
            }
        }
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(res));
//        return df.format(res);

    }
    static class Diff implements Comparable{
        int index;
        int value;
        public Diff(int index, int value) {
            this.index = index;
            this.value = value;
        }
        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Object o) {
          Diff diff = (Diff) o;
          if(this.value > diff.value)
              return 1;
          else if(this.value == diff.value)
              return 0;
          else
              return -1;

        }
    }

}
