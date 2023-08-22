package leetcode.hot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 */
public class Main_48_rotate_image {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate2(matrix);
    }

    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[row][col];
        //第i行变成了倒数第i列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[j][col - i - 1] = matrix[i][j];
            }
        }
        matrix = dp;
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void rotate2(int[][] matrix) {
        int len = matrix.length;
        //水平翻转
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - i - 1][j];
                matrix[len - i - 1][j] = temp;
            }
        }
        //主对角线翻转
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
