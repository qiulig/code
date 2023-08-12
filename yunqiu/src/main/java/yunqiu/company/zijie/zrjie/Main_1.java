package yunqiu.company.zijie.zrjie;

import java.util.*;

/**
 * СByte��СDance�����ֽп��𳵵�ֽ����Ϸ����Ϸ��������:
 1. ��ʼ���������ƽ��52���˿��ƣ�ÿ����26��
 2. СByte�ȿ�ʼ������1���Ʒ���;
 3. �������������˳��(���ӵ�1�ŵ����1�ŵ�˳����ƣ������е�˳�򲻿��Ա�����)��
    ���˿��ƣ���һ���˿���ѹ��ǰһ���˿�����;
 4. �������֮ǰ���µ�ĳ���˿���s�뽫Ҫ���µ��˿���t������ͬ����ǰ��һ�ô�s��t֮���������(����s��t��������) ;
 5. ������ϵ�26���ƶ��������Ϸ�����������˫����õ����������������һ�ʤ����
 �������������ͬ����ƽ�֡�
 * ��������:
 *      ����������У�ÿ��26�����֣��ֱ��ʾ��λ��ҳ�ʼ��������䵽���Ƶĵ�������һһ��ΪСByte���ֵ����ơ�
 * �������:
 *     ��ƽ�������"Draw", ���������ʤ��ҵ�����("Byte�����ߡ�Dance") ��
 * ʾ��
 *     10  2  5   6  13  11  11  4  10  8  12  5  4  1  8  1  7  12  4  13  6   9   9   9  5  7
 *     6   3  13  8   2   3  7   3  2   2  12 11 10 6  10  1  1  12  3  5   7  11  13  4  8  9
 * ���������
 *       Byte

 */
public class Main_1 {
    public static void main(String[] args) {
//        Scanner sr = new Scanner(System.in);
//        String str = sr.nextLine();
//        String s[] = str.split(" ");
//
//        ArrayList<Integer> a1 = new ArrayList<>();
//        for (int i = 0; i < s.length; i++) {
//            a1.add(Integer.parseInt(s[i]));
//        }
//        String str2 = sr.nextLine();
//        String s2[] = str2.split(" ");
//
//        ArrayList<Integer> a2 = new ArrayList<>();
//        for (int i = 0; i < s.length; i++) {
//            a2.add(Integer.parseInt(s2[i]));
//        }
        Integer arr1[] = { 10 , 2,  5 ,  6,  13 , 11 , 11,  4 , 10,  8,  12,  5 , 4 , 1,  8,  1,  7,  12 , 4,  13,  6,   9,   9,   9,  5,  7};
        Integer arr2 []= {6 ,  3,  13,  8,   2,   3,  7 ,  3,  2,   2,  12 ,11 ,10, 6,  10,  1,  1,  12,  3,  5,   7,  11,  13,  4,  8,  9};
        List a1 = Arrays.asList(arr1);
        List a2 = Arrays.asList(arr2);
        solution(a1, a2);
        solution2(a1,a2);
    }

    private static void solution(List<Integer> person1, List<Integer> person2) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> res1 = new ArrayList<>();
        ArrayList<Integer> res2 = new ArrayList<>();
        //���ڴ洢�������ݣ�iΪ��������һ����ҵ���
        ArrayList<Integer> allnum = new ArrayList<>();
        for (int i = 0; i < person1.size(); i++) {
            allnum.add(person1.get(i));
            allnum.add(person2.get(i));
        }
        //����ģ����Ϸ
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < allnum.size(); i++) {
            if (list.isEmpty()) {
                list.add(allnum.get(i));
                stack.push(allnum.get(i));
            } else {
                if (list.contains(allnum.get(i))) {
                    //1�����Ӯ����
                    if (i % 2 == 0) {
                        int nums = allnum.get(i);
                        //������ͬ����
                        res1.add(nums);
                        while (nums != stack.peek()) {
//                            int num = stack.pop();
                            res1.add(stack.peek());
                            list.remove(Integer.valueOf(stack.pop()));
                        }
                        //������ͬ����
                        res1.add(nums);
                        list.remove(Integer.valueOf(stack.pop()));

                    } else {
                        int nums = allnum.get(i);
                        //������ͬ����
                        res2.add(nums);
                        while (nums != stack.peek()) {
//                            int num = stack.pop();
                            res2.add(stack.peek());
                            list.remove(Integer.valueOf(stack.pop()));
                        }
                        //������ͬ����
                        res2.add(nums);
                        list.remove(Integer.valueOf(stack.pop()));
                    }
                } else {
                    list.add(allnum.get(i));
                    stack.add(allnum.get(i));
                }

            }
        }
        if (res1.size() > res2.size()) {
            System.out.println("Byte");
        } else if (res1.size() == res2.size()) {
            System.out.println("Draw");
        } else {
            System.out.println("Dance");
        }
    }

    private static void solution2(List<Integer> person1, List<Integer> person2) {
        int count1 = 0;
        ArrayList<Integer> allnum = new ArrayList<>();
        for (int i = 0; i < person1.size(); i++) {
            allnum.add(person1.get(i));
            allnum.add(person2.get(i));
        }
        //����ģ����Ϸ
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < allnum.size(); i++) {
            if (list.isEmpty()) {
                list.add(allnum.get(i));
            } else {
                if (list.contains(allnum.get(i))) {
                    //1�����Ӯ����
                    if (i % 2 == 0) {
                        int index = list.indexOf(allnum.get(i));
                        count1 += list.size() - index + 1;
                        while (list.size() != index) {
                            list.pollLast();
                        }
                        //2�����Ӯ����
                    } else {
                        int index = list.indexOf(allnum.get(i));
                        //���ﲻ��¼2�����Ӯ�ö�����
                        while (list.size() != index) {
                            list.pollLast();
                        }
                    }
                } else {
                    list.addLast(allnum.get(i));
                }
            }
        }
        //������
        if(count1 > allnum.size()-count1){
            System.out.println("Byte");
        } else if (count1 == allnum.size()-count1) {
            System.out.println("Draw");
        } else {
            System.out.println("Dance");
        }
    }
}



