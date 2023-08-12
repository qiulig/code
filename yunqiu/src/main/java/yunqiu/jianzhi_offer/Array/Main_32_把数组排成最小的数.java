package yunqiu.jianzhi_offer.Array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class Main_32_把数组排成最小的数 {
    public static void main(String[] args) {
        int numbers []= {3334,3,3333332};
        PrintMinNumber(numbers);
    }
    public static String PrintMinNumber(int [] numbers) {
        if(numbers.length<=0||numbers == null)
            return "";
        //排序，可得到最大的数为numbers[len-1]
        Arrays.sort(numbers);
        //求位数
        int count = 0;
        int Max_ = numbers[numbers.length-1];
        //得到最大的数的位数
        while(Max_>0) {
            count++;
            Max_ = Max_/10;
        }
        //将数组变成字符串数组
        String str[] = new String[numbers.length];
        for(int i = 0;i<numbers.length;i++){
            str[i] = ""+numbers[i];
        }
        //补位
        for(int i = 0;i<numbers.length;i++){
            //得到补位要填充的数
            String tmp ="" +str[i].charAt(str[i].length()-1);
            //原数组的位数
            int len =str[i].length();
            //补足到相同的位数
            for(int j = 0;j<count-len;j++)
            {
                str[i] = str[i]+tmp;
            }
        }
        //排序
        ArrayList<Integer> ss= new ArrayList<>();
        //该数组的索引对应着numbers的索引
        String strcopy[] = str.clone();
        //将其进行从小到大的排序
        Arrays.sort(str);
        //得到从小到大排序后原数组所在的索引
        for(int i = 0;i<numbers.length;i++){
            for(int j = 0;j<numbers.length;j++){
                if(str[i].equals(strcopy[j])){
                    ss.add(j);
                }
            }
        }
        //将索引进行拼接得到结果
        String res = "";
        for(int i = 0;i<numbers.length;i++){
            res = res +numbers[ss.get(i)];
        }
        return res;
    }
}
