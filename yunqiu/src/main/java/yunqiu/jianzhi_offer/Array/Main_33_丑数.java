package yunqiu.jianzhi_offer.Array;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Main_33_丑数 {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(7));
    }
    public static int GetUglyNumber_Solution(int index) {
        int[] arr = new int[index];
        if (index == 0)
            return 0;
        arr[0] = 1; //第一个丑数为1，放入数组的第一个元素
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        for (int i = 1; i < index; i++) {
            //寻找3个序列中最小的那个数
            arr[i] = Math.min(arr[t2] * 2, Math.min(arr[t3] * 3, arr[t5] * 5));
            //最小的那个数的序列值加1
            if (arr[t2] * 2 == arr[i])
                t2++;
            if (arr[t3] * 3 == arr[i])
                t3++;
            if (arr[t5] * 5 == arr[i])
                t5++;
        }

        return arr[index - 1];

    }

}
