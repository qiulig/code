package yunqiu.leetcode.Arrays;

import java.util.Arrays;

public class Main_16 {
    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3)
            return nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        int ans = Math.abs(nums[0]+nums[1]+nums[2]-target);
        int tmp = Integer.MAX_VALUE;
        int flag = 1;
        for(int i = 0;i<nums.length;i++){
            int left = i+1;
            int right =nums.length-1;
            int arr = nums[i];
            while(left<right){
                tmp = nums[left]+nums[right]+arr;
                if(ans> Math.abs(tmp - target) && tmp > target){
                    ans = Math.abs(tmp-target);
                    flag = 1;
                }else if(ans > Math.abs(tmp - target) && tmp < target){
                    ans = Math.abs(tmp-target);
                    flag = -1;
                }
                if(tmp - target > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return  flag * ans +  target;
    }
    public static void main(String[] args) {
      int []arr = {1,1,-1,-1,3};
        System.out.println(threeSumClosest(arr,3));
    }

}
