package leetcode.tree;
import java.util.LinkedList;
import java.util.Queue;

public class Main_623 {

    //  Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    static class Solution {
        public static TreeNode addOneRow(TreeNode root, int v, int d) {
            TreeNode node = new TreeNode(v);
            if(d == 1){
                node.left = root;
                return node;
            }
            if(d==0){
                node.right = root;
                return node;
            }
            if(root != null && d>1){
                root.left = addOneRow(root.left ,v, d > 2 ? d - 1 : 1);
                root.right = addOneRow(root.right,v, d > 2 ? d - 1 : 0);
            }
            return root;
        }
        public static TreeNode addOneRow2(TreeNode root, int v, int d) {
            Queue<TreeNode> queue = new LinkedList<>();
            if(d==1){
                TreeNode node = new TreeNode(v);
                node.left = root;
                return node;
            }
            queue.add(root);
            int depth = 1;
            TreeNode temp;
            while (!queue.isEmpty()){
                if(depth == d-1)
                    break;
                int size = queue.size();
                while (size-->0){
                    temp = queue.remove();
                    if(temp.left!=null)
                        queue.add(temp.left);
                    if(temp.right!=null)
                        queue.add(temp.right);
                }
                depth++;
            }
            TreeNode parent;
            while (!queue.isEmpty()){
                parent = queue.remove();

                temp = new TreeNode(v);
                temp.left = parent.left;
                parent.left = temp;

                temp = new TreeNode(v);
                temp.right = parent.right;
                parent.right = temp;

            }
            return root;
        }
        public static void main(String[] args) {
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.right = new TreeNode(6);
            root.left.left = new TreeNode(3);
            root.left.right = new TreeNode(1);
            root.right.left = new TreeNode(5);
            int v = 1;
            int d  = 3;
            TreeNode ans = addOneRow(root,v,d);

        }
    }
}
