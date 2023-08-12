package company.小米;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        String str = sr.nextLine();
        String[] arr = str.split("\\s+");
        int a[] = new int[arr.length-1];
        for(int i = 0;i<a.length;i++){
            a[i] = Integer.parseInt(arr[i+1]);
        }
//        int a[] = {60 ,76 ,66 ,76 ,85 ,55 ,61 ,71 ,84 ,62};
        System.out.println(solution(a));

    }

    private static int solution(int[] arr) {
        int bonus[] = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            bonus[i] = 1;
        }
        //从左到右看,从第二个到最后一个数的更新
        //看自己左侧的厨师分数，比自己小的，在他的基础上加一
        for(int i = 1;i<=arr.length-1;i++){
            //如果右边的数大于左边的数，右边的数 = 左边的数 + 1
            if(arr[i]>arr[i-1]){
                bonus[i] = bonus[i-1] + 1;
            }
        }
        //从右到左看,从第2个到倒数第二个的更新，
        // 如果左边的数大于右边的数，并且此时左边的bonus小于右边的，左边的数  = 右边的 + 1
        //看自己右侧的厨师分数，比自己小的，max(自己，右侧+1)
        for(int j = arr.length-2;j>=0;j--){
            if(arr[j]>arr[j+1]){
                bonus[j] =Math.max(bonus[j+1]+1,bonus[j]);
            }
        }
        //计算得的数
        int res = 0;
        for(int i = 0;i<bonus.length;i++){
            res +=bonus[i];
        }
        return res;
    }
}
