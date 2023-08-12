package yunqiu.company.zhaoyin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
//        String str = sr.nextLine();
        String str = "";
        solution(str);
    }
    public static List<String> solution(String str){
        List<String> res = new ArrayList<>();
        int index = 0;
        for(int i = 0;i<str.length();i++){
            //判断字符是不是[a-z][A-Z]
            if((str.charAt(i)>='a' && str.charAt(i)<='z')||(str.charAt(i)>='A' && str.charAt(i)<'Z')){
            }else{
                //碰到中文字符，将之前的英文添加到res里面
                res.add(str.substring(index,i));
                //将中文编码加到res里面
                res.add(str.charAt(i)+"");
                //将下次要截取的索引坐标改成下一个字符的索引坐标
                index = i+1;
            }
        }
        //如果一致后面一直没遇到中文字符，但是后面的英文字符也没加到res里面，则将其添加
        if(index < str.length()){
            res.add(str.substring(index,str.length()));
        }
        return res;
    }
}
