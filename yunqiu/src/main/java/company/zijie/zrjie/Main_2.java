package company.zijie.zrjie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 *
 *2019年3月12日，全球的Bytedancer共同庆祝字节跳动成立七周年。七年前的今天，初创团队把营业执照领回锦秋家园，七年后的今天， 字节跳动在不断地快速成长，吸纳全球优秀的人才加入。
 为了纪念2012年3月12日这个重要的日子，我们希望能够对于之后的任何一个日期， 计算出公司已经成立了多少天。人工计算或者Excel表操作是费时的，我们希望你能实现这个功能，并期待优秀的你加入我们。
 输入描述:
        第一行为一个整数，表示有T组数据，接下去T行每行三个整故y，m，d,分别表示年、月、日。
 输出描述:
        对于每组数据，输出1个整数表示从2012年3月12日出的日期经过了多少天，
 示例1
 输入
    2
    2012 3 13
    2019 3 12
 输出
    1
    2556
 */
public class Main_2 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        int T = sr.nextInt();
        int res[] = new int[T];
        int ress[] = new int[T];
        for (int i = 0; i < T; i++) {
            int year = sr.nextInt();
            int month = sr.nextInt();
            int day = sr.nextInt();

            res[i] = solution(year, month, day);

            ress[i] = (int) solution1(year,month,day);
        }

        for (int i = 0; i < T; i++) {
            System.out.println(res[i]);
        }

        for (int i = 0; i < T; i++) {
            System.out.println(res[i]);
        }
    }

    private static double solution1(int year, int month, int day) {
        long days = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formdate = "2012-3-12 10:00:00";
        String ToDate = year + "-" + month + "-" + day + " 10:00:00";
        long nday = 1000*24*60*60; //ÿ��ĺ�����
        long nhour = 1000*60*60;   //ÿСʱ�ĺ�����
        long nminute = 1000*60;   //ÿ���ӵĺ�����
        try {
            Date date2 = format.parse(ToDate);
            Date date1 = format.parse(formdate);
            //�������ʱ��ĺ���ʱ�����
            long diff = date2.getTime()-date1.getTime();
            days = diff / nday;
            long hour = diff % nday /nhour;
            long min = diff % nday % nhour /nminute;
            return days;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }
    private static int solution(int year, int month, int day) {
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        int time = 0;
        //�㵽��һ��(year-1)��3��12��
        if (year - 1 > 2012) {
            for (int i = 2013; i < year; i++) {
                //��2013��ǰһ��year-1������ �ж��ٸ�
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    count++;
                }
            }
            //��ʱ��Ϊ ��2013��3��12�յ�year-1��3��12�յ�ʱ��
            time = 365 * (year - 2012 - 1) +count;
        }
        //�Ѿ��㵽(year-1):3:12��ʱ���ˣ�������ʣ�µ�
            //�㵽12��
            time += (31 - 12) + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 31;
            //�㵽��һ����β��
            for (int i = 0; i <= month - 2; i++) {
                time += days[i];
            }
            //��������µ�ʱ��
            time += day;
            //������������겢�����ʱ���Ѿ�����3�·��ˣ����1
            if(month>=3){
                if(year%4 ==0 && year%100 != 0 || year%400 == 0)
                    time++;
            }
        return time;
    }
}
