package yunqiu.jianzhi_offer.Array;

/**
 * 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Main_66_机器人的运动范围 {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(rows<1||cols<1||threshold<0)
        {
            return 0;
        }
        boolean []visit=new boolean[rows*cols];
        return count(threshold,rows,cols,visit,0,0);
    }
    private static int count(int threshold, int rows, int cols,
    boolean[] visit, int row, int col) {
    int res=0;
    if(check(threshold,rows,cols,visit,row,col))
    {
        visit[row*cols+col]=true;
        res=1+count(threshold,rows,cols,visit,row,col+1)
                +count(threshold,rows,cols,visit,row,col-1)
                +count(threshold,rows,cols,visit,row+1,col)
                +count(threshold,rows,cols,visit,row-1,col);
    }
    return res;
    }
    private static boolean check(int threshold, int rows, int cols, boolean[] visit, int row, int col) {
    if (row >= 0 && row < rows && col >= 0 && col < cols
            && visit[row * cols + col] == false
            &&getNum(col) + getNum(row) <= threshold) {
        return true;
    }
    return false;
    }
    //获取位数之和
    private static int getNum(int num) {
    int sum = 0;
    while (num > 0) {
        sum += num % 10;
        num /= 10;
    }
    return sum;
    }
}

