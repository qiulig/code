package jianzhi_offer.Array;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，如
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class Main_1_二维数组的查找 {
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
