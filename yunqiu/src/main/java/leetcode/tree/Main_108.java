package leetcode.tree;

import java.util.Arrays;

public class Main_108 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        TreeNode root =new TreeNode( nums[nums.length/2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length/2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2+1,nums.length));
        return root;
    }
    public static void main(String[] args) {
        int arr[] = {-10,-3,0,5,9};
        TreeNode ans =sortedArrayToBST(arr);

    }
}
