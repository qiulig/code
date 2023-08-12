package company.百度;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main_2 {
    public static void main(String[] args) {
        String s = "012";
        System.out.println(s.substring(1,1));
        Scanner sr = new Scanner(System.in);
        String str = sr.nextLine();
        System.out.println(solution(str));
        System.out.println(kmp(str));
    }
    public static int solution(String str){
        if(str == null )
            return 0;
        else if(str.trim().equals(""))
            return 1;
        else if(str.length() == 0)
            return 0;
        else{
            List<String> list = new ArrayList<>();
            String temp = str;
            list.add(str);
            for(int i = 0;i<str.length();i++){
                //首字符移到末尾并记录所得的字符串，
                temp = temp.substring(1,temp.length())+temp.charAt(0);
                //如果list里面没有该字符串则加入list
                if(!list.contains(temp)){
                    list.add(temp);
                }
            }
            return list.size();
        }
    }
    public static int kmp(String str){
        int len = str.length();
        int [] next = new int[len+1];
        next[0] = -1;
        int k = -1;
        int j  = 0;
        while (j < len ){
            if(k== -1 || str.charAt(k) == str.charAt(j)){
                next[++j] = ++k;
            }else{
                k = next[k];
            }
        }
        int res = len % (len - next[len]);
        if(res != 0)
            return len;
        else
            return len-next[len];
    }
}
