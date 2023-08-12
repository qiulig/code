package jianzhi_offer.tree;

import java.util.PriorityQueue;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，
 * （5，3，7，2，4，6，8）
 * 中，按结点数值大小顺序第三小结点的值为4。
 */
public class Main_62_二叉搜索树的第K个结点 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    static TreeNode KthNode(TreeNode pRoot, int k) {
        preOrderRec(pRoot);
        if(queue.size()<k )
            return null;
        for(int i = 0;i<k-1;i++){
            queue.poll();
        }
        return new TreeNode( queue.poll());
    }
    public static void preOrderRec(TreeNode root){
        if(root!=null){
            queue.add(root.val);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode list = new TreeNode(8);
        list.left = new TreeNode(6);
        list.right = new TreeNode(10);
        list.left.left = new TreeNode(5);
        list.left.right =new TreeNode(7);
        list.right.left = new TreeNode(9);
        list.right.right = new TreeNode(11);
        KthNode(list,3);
    }
}
