package leetcode.tree;

import java.util.Arrays;

public class Main_106 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
        public static TreeNode buildTree(int[] inorder, int[] postorder) {
            if(inorder.length == 0||postorder.length == 0)
                return null;
            TreeNode root = new TreeNode(postorder[postorder.length-1]);
            for(int i = 0;i<inorder.length;i++){
                if(inorder[i] == postorder[postorder.length-1]){
                    root.left = buildTree(Arrays.copyOfRange(inorder,0,i),Arrays.copyOfRange(postorder,0,i));
                    root.right = buildTree(Arrays.copyOfRange(inorder,i+1,inorder.length),Arrays.copyOfRange(postorder,i,postorder.length-1));
                    break;
                }
            }
            return root;
        }
    public static void main(String[] args) {
        int []postorder = {9,15,7,20,3};
        int []inorder = {9,3,15,20,7};
        TreeNode res =buildTree(inorder,postorder);
    }
}
