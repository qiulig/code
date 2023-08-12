package yunqiu.company.∞Æ∆Ê“’;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        int N  = sr.nextInt();
        int M  = sr.nextInt();
        int P  = sr.nextInt();
        int a[] = new int[N];
        for(int i = 0;i<N;i++){
            a[i] = sr.nextInt();
        }
        List<List<String>> list = new ArrayList<>();
        for(int i = 0;i<M;i++){
            List<String> temp= new ArrayList<>();
            temp.add(sr.next());
            temp.add(sr.next());
            list.add(temp);
        }
        System.out.println(solution(list,P,a));
    }

    private static int  solution(List<List<String>> list, int p, int[] a) {
        for(int i = 0;i<list.size();i++){
            if(list.get(i).get(0).equals( "A")){
                int index = Integer.parseInt(list.get(i).get(1)) - 1;
                a[index] ++;
            }else{
                int index = Integer.parseInt(list.get(i).get(1)) - 1;
                a[index] --;
            }
        }
        int res = 1;
        for(int i = 0;i<a.length;i++){
            if(a[p-1]<a[i]){
                res++;
            }
        }
        return res;
    }
}
//
//public class Main_1 {
//    public static void main(String[] args) {
//        Scanner sr = new Scanner(System.in);
//        int N  = sr.nextInt();
//        int M  = sr.nextInt();
//        int P  = sr.nextInt();
//        int a[] = new int[N];
//        for(int i = 0;i<N;i++){
//            a[i] = sr.nextInt();
//        }
//        List<Category> lists = new ArrayList<>();
//        for(int i = 0;i<M;i++){
//            lists.add(new Category(sr.next(),sr.nextInt()));
//        }
//        System.out.println(solution(lists,P,a));
//    }
//
//    private static int  solution(List<Category> lists, int p, int[] a) {
//        for(int i = 0;i<lists.size();i++){
//            if(lists.get(i).x.equals("A")){
//                a[lists.get(i).getIndex()-1]++;
//            }else{
//                a[lists.get(i).getIndex()-1]--;
//            }
//        }
//        int res = 1;
//        for(int i = 0;i<a.length;i++){
//            if(a[p-1]<a[i]){
//                res++;
//            }
//        }
//        return res;
//    }
//    }
// class Category{
//    String x;
//    int index;
//
//    public Category(String x, int index) {
//        this.x = x;
//        this.index = index;
//    }
//
//    public String getX() {
//        return x;
//    }
//
//    public void setX(String x) {
//        this.x = x;
//    }
//
//    public int getIndex() {
//        return index;
//    }
//
//    public void setIndex(int index) {
//        this.index = index;
//    }
//}
