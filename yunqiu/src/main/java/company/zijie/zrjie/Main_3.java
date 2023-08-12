package company.zijie.zrjie;

/**
* Bytedance决定对所有新人展开次针对性的培训。公司有很多新人，每个人想学的内容都不一样。限制每个人只能在本次培训中学习一门课程，经过统计，新人们总共想学n门课程，每门课程报名的人数分别为a1,a2，... ,an,为了保证公平与方便管理，公司决定采用小班教学模式，所有的小班内人数相同，同一班级内的课程内容相同。由于人力有限，我们希望在满足以上前提条件的同时，班级数量尽可能地少，问:最少需要开多少个小班。
 输入描述:
 第一行为一个整数n,表示有n门课程，第2行为n个整数，每个整做之间用一个字格分隔，分别为a1,a2，.. ,an,表示门课程的报名人数。
 输出描述:
 输出最少需要开多少个小班。
 示例1
 输入
 3
 1    1    2
 输出
 4
 */
public class Main_3 {
    public static void main(String[] args) {
//        Scanner sr = new Scanner(System.in);
//        int n = sr.nextInt();
//        int[] arr = new int[n];
//        String ss = sr.nextLine();
//        String s1[]  = ss.split(" ");
//        for(int i = 0;i<s1.length;i++){
//            arr[i] = Integer.parseInt(s1[i]);
//        }
        int [] arr = {16,16,18};
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        //��������������
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
        }
        //�����Լ��
        int gcdNum = arr[0],t;
        for(int  i = 0;i<(arr.length-1);i++){
            t = 0;
            while(arr[i+1]!=0){
                t = arr[i+1];
                arr[i+1] = gcdNum % arr[i+1];
                gcdNum = t;
            }
        }

        return sum/gcdNum;
    }
    public static int get_gcd(int a,int b){
        int max = a > b ? a : b;
        int min = a > b ? b : a;
        if(max%min == 0){
            return min;
        }else{
            return get_gcd(min,max % min);
        }
    }

}
