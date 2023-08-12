package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Main_101 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    //µÝ¹é
    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return false;
        return Symmetric(root.left,root.right);
    }
    public static boolean Symmetric(TreeNode leftroot,TreeNode rightroot) {
        if(leftroot==null && rightroot==null)
            return true;
        if(leftroot==null || rightroot == null)
            return false;
        if(leftroot.val != rightroot.val)
            return false;
        return Symmetric(leftroot.left,rightroot.right) && Symmetric(leftroot.right,rightroot.left);
    }
    //µü´ú
    public static boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1==null && node2==null)
                continue;
            if(node1==null || node2==null)
                return false;
            if(node1.val!=node2.val)
                return false;
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        System.out.println(isSymmetric(root));
        System.out.println(isSymmetric2(root));
    }
}
