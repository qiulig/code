package yunqiu.leetcode.tree;

import java.util.Arrays;

public class Main_105 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public  static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 0;i<inorder.length;i++){
            if(preorder[0] == inorder[i]){
                root.left = buildTree(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
                root.right = buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
                break;
            }
        }
        return root;
    }
    public static void main(String[] args) {
        int []preorder = {3,9,20,15,7};
        int []inorder = {9,3,15,20,7};
        TreeNode res =buildTree(preorder,inorder);
    }
}
