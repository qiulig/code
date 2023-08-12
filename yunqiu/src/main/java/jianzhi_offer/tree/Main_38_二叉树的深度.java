package jianzhi_offer.tree;

/**
 * 求二叉树的深度
 */
public class Main_38_二叉树的深度 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //①如果一棵树只有一个结点，它的深度为1。
    //②如果根结点只有左子树而没有右子树，那么树的深度应该是其左子树的深度加1；同样如果根结点只有右子树而没有左子树，那么树的深度应该是其右子树的深度加1。
    //③如果既有右子树又有左子树，那该树的深度就是其左、右子树深度的较大值再加1。
    public class Solution {
        public int TreeDepth(TreeNode root) {
            //----递归求二叉树深度----
            if (root == null) {
                return 0;
            }
            int left = TreeDepth(root.left);
            int right = TreeDepth(root.right);
            return (left > right) ? (left + 1) : (right + 1);
        }

    }
}
