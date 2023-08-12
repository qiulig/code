package yunqiu.jianzhi_offer.Array;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 */
public class Main_64_滑动窗口的最大值 {
public static ArrayList<Integer> maxInWindows(int [] num, int size) {
    ArrayList<Integer> arr = new ArrayList<>();
    if (num==null)
        return arr;
    if (num.length<size||size<=0)
        return arr;
    Deque<Integer> queue = new LinkedList<>();
    for (int i = 0; i<num.length; i++){
        //如果前面的数比插入的数小，直接把前面删除(因为不可能成为后面窗口的最大值)
        while (!queue.isEmpty()&&num[i]>=num[queue.getLast()])
            queue.pollLast();
        //如果前面的元素比k大，判断是否还在窗口范围内，不在则移除
        while (!queue.isEmpty()&&queue.getFirst()<i-(size-1))
            queue.pollFirst();
        queue.offerLast(i);
        if (i+1>=size)
            arr.add(num[queue.getFirst()]);
    }
    return arr;
}
    public static void main(String[] args) {
        int arr[] = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> integers = maxInWindows(arr, 3);
        integers.forEach(System.out::println);

    }

}
