package yunqiu.company;

public class Main_1 {

    public static void main(String[] args) {
//        Scanner sr = new Scanner(System.in);
//        int a = sr.nextInt();
//        int b = sr.nextInt();
//        reverseAdd(a,b);
        System.out.println(reverseAdd(12,31));
    }
    public static int  reverseAdd(int a,int b){
        if((a<=1 && a>=70000) || (b<=1 && b>=70000))
            return -1;
        String  str1 =new StringBuilder(a +"").reverse().toString();
        String str2 =new StringBuilder( b +"").reverse().toString();
        return Integer.parseInt(str1) +Integer.parseInt(str2);
    }

}
