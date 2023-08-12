package yunqiu.leetcode.Arrays.回溯;

/**
 * 79、单词搜索
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * https://leetcode-cn.com/problems/word-search/
 */
//执行用时 :11 ms, 在所有 Java 提交中击败了79.40%的用户
//内存消耗 :45 MB, 在所有 Java 提交中击败了75.30%的用户
public class Main_79_单词搜索 {
    public static boolean exist(char[][] board, String word) {
        int[][] isvisited = new int[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(word.charAt(0) == board[i][j] && backTrace(i,j,0,word,isvisited,board))
                    return true;
            }
        }
       return false;
    }

    private static boolean backTrace(int startRow, int startColumn, int index, String word, int[][] isvisited, char[][] board) {
        if(index == word.length())
            return true;
        if( startRow>=board.length || startRow<0 || startColumn>= board[0].length || startColumn<0
                ||isvisited[startRow][startColumn]==1
                ||board[startRow][startColumn]!=word.charAt(index)){
            return false;
        }
        isvisited[startRow][startColumn] = 1;
        if(backTrace(startRow+1,startColumn,index+1,word,isvisited,board)             //下
                ||backTrace(startRow-1,startColumn,index+1,word,isvisited,board)      //上
                ||backTrace(startRow,startColumn+1,index+1,word,isvisited,board)   //右
                ||backTrace(startRow,startColumn-1,index+1,word,isvisited,board))  //左
             {
                return true;
        }else{
            //回溯
            isvisited[startRow][startColumn] = 0;
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }


}
