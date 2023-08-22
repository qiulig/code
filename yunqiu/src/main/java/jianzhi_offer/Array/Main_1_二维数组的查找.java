package jianzhi_offer.Array;

/**
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳��������
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ��������
 * �ж��������Ƿ��и�������
 */
public class Main_1_��ά����Ĳ��� {
    public static class Solution {
        public static boolean Find(int target, int[][] array) {
            int row = array.length - 1;
            int col = 0;
            while (row >= 0 && col <= array[0].length - 1) {
                if (array[row][col] > target) {
                    row--;
                } else if (array[row][col] < target) {
                    col++;
                } else {
                    return true;
                }
            }
            return false;
        }

        public static void main(String[] args) {
            int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            System.out.println(Find(0, a));
        }
    }
}
