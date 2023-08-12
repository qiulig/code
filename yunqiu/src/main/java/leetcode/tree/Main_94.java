package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main_94 {

      //Definition for a binary tree node.
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
      }

    static class Solution {
        static List<Integer> res = new ArrayList();
        //µÝ¹é
        public static List<Integer> inorderTraversal(TreeNode root) {
            if(root==null)
                return res;
            if(root.left!=null)
                inorderTraversal(root.left);
            res.add(root.val);
            if(root.right!=null)
                inorderTraversal(root.right);
            return res;
        }
        //µü´ú
        public static List<Integer> inorderTraversal2(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur!=null ||!stack.isEmpty()){
                while (cur!=null){
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }
            return ans;
        }
        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
//            inorderTraversal(root);
            inorderTraversal2(root);
        }
    }
}
