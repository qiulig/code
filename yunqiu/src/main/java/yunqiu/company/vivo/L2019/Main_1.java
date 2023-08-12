package yunqiu.company.vivo.L2019;

import java.util.*;

public class Main_1 {
    public static void main(String[] args) {
        String[]arr = {"abc","Abc","123","1","1bc","CBD","abcd","a"};
        Set strSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String str1 = (String) o1;
                String str2 = (String) o2;
                int temp = str1.length()-str2.length();
                //如果两个数组的长度相等则直接按字典序排列，否则
                if(temp==0){
                    int  t1=0;
                    int  t2=0;
                    for(int i=0;i<str1.length();i++){
                        char c1=str1.charAt(i);
                        char c2=str2.charAt(i);
                        if(c1>='A'&&c1<='Z'){
                            t1 = (c1-'A') * 2 + 32;
                        }else if(c1>='a'&&c1<='z'){
                            t1 = (c1-'a') * 2 + 33;
                        }else if(c1>='0'&&c1<='9'){
                            t1 = c1 + 35;
                        }
                        if(c2>='A'&&c2<='Z'){
                            t2 = (c2 -'A') * 2 + 32;
                        }else if(c2>='a'&&c2<='z'){
                            t2 = (c2-'a') * 2 + 33;
                        }else if(c2>='0'&&c2<='9'){
                            t2=c2 + 35;
                        }
                        if(t1!=t2)
                            break;
                    }
                    return t1-t2;
                }else{
                    return temp;
                }
                //  return temp == 0 ?str1.compareTo(str2) : temp ;
            }
        });
        for(int i = 0;i<arr.length;i++){
            strSet.add(arr[i]);
        }
        for(Iterator it = strSet.iterator(); it.hasNext();){
            System.out.print(it.next()+" ");
        }
    }

}
