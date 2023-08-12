package jianzhi_offer.Array;

/**
 * 矩阵中的路径
 */
public class Main_65_矩阵中的路径 {
public static class Solution {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)    {
        int[] flag = new int[matrix.length];
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(helper(matrix, rows, cols, i, j, str, 0, flag)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag){
        int index = i * cols + j;
        if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1){
            /// /下标不符合，index对应的值不为和字符数组中的不一致，或者该index已经被访问，这些情况只要有符合的就返回false
            // 只有上面的所有情况都不符合，也就是值相等，且没有访问过，下标不符合
            return false;
        }
        if(k == str.length - 1){
            return true;
        }
        flag[index] = 1;
        if(helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                ||helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                ||helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                ||helper(matrix, rows, cols, i , j + 1, str, k + 1, flag)){
            return true;
        }
        flag[index] = 0;
        return false;
    }
    }
    public static void main(String[] args) {
        char[]arr = {'a','b' ,'c','e','s','f','c','s','a','d','e','e'};
        int rows = 3;
        int col = 4;
        char str1[] = {'b','c','c','e','d'};
        char str2[] = {'a','b','c','b'};
        Solution.hasPath(arr,rows,col,str1);
    }
}
