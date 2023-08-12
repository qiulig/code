package yunqiu.suanfa;


//旅行商问题
public class Main_贪心_旅行商 {
    public static void main(String[] args) {
        String city[] = {"A","B","C","D","E","F","G","H","I","J"};
        int x[] = {2066,935,1270,1389,984,2253,949,87,3094,2706};
        int y[] = {2333,1304,200,700,2810,478,3025,2483,1883,3130};
        double distance[][] = Caldistance(x,y);
        solve(distance,city);
    }
    //计算距离
    public static double[][] Caldistance(int x[],int y[]){
        double [][] distance = new double[x.length][x.length];
        for(int i = 0;i<x.length;i++){
            for(int j = 0;j<x.length;j++){
                //欧式距离
                distance[i][j] = Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
            }
        }
        return distance;
    }
    public static void solve(double[][]distance,String []city){
        double sum = 0;
        //记录访问过的城市
        int visited[] = new int[distance.length];
        //记录依次访问的城市，得到最小的距离
        String path[] = new String[distance.length];
        //假设从第一个城市A开始
        path[0] = "A";
        //访问过的点记录为1
        visited[0] = 1;
        //当前正在访问的点
        int k = 0;
        //第一次设下一个城市为Index为1的B城市
        int nextCityIndex = 1;
        //初始化最小的距离
        double mindistance = Double.MAX_VALUE;
        //记录以及访问过多少个城市了
        int count = 1;
        while(count<city.length){
            for(int i = 0;i<city.length;i++){
                //如果该点没被访问
                if(visited[i]==0){
                    //求出 从正在访问的点k到下一个点的最小距离，即为下一个要被访问的城市
                    if(distance[k][i]<mindistance){
                        mindistance  = distance[k][i];
                        //获取下一个要被访问的城市的下标索引
                        nextCityIndex = i;
                    }
                }
            }
            //依次访问的点的总路程
            sum = sum + mindistance;
            //将得到的下一个要访问的城市加入到path中
            path[count++] = city[nextCityIndex];
            //该点被访问，置为1
            visited[nextCityIndex] = 1;
            //将访问的城市起点改成求得的下一个城市的点的坐标索引
            k = nextCityIndex;
            //再次初始化
            mindistance = Double.MAX_VALUE;
        }
        //得出依次访问的结果，输出
        for(int i = 0;i<path.length;i++){
            System.out.print(path[i]+" ");
        }
    }
}
