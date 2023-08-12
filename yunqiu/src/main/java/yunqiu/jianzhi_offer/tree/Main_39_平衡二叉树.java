package yunqiu.jianzhi_offer.tree;

/**
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 预备知识：平衡二叉树是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * 思想：从根节点开始，先判断左右子树的高度差是否超过1，然后接着判断左右子树是否是平衡二叉树。这边用到了递归思想。
 *
 */
public class Main_39_平衡二叉树 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    //平衡二叉树是一棵空树或它的左右两个子树的高度差的绝对值不超过1
//并且左右两个子树都是一棵平衡二叉树。
    public static class Solution {
        public static  boolean IsBalanced_Solution(TreeNode root) {
            //一棵空树就是平衡二叉树
            if(root==null){
                return true;
            }
            int left = treeDepth(root.left);
            int right = treeDepth(root.right);
            int diff = left - right;
            if(diff>1||diff<-1){
                return false;
            }
            return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
        }
        public static  int treeDepth(TreeNode root) {
            //----递归求二叉树深度----
            if(root == null){
                return 0;
            }
            int left = treeDepth(root.left);
            int right = treeDepth(root.right);

            return (left>right)?(left+1):(right+1);
        }

        public boolean IsBalanced_Solution2(TreeNode root) {
            if( root == null) { //一棵空树就是平衡二叉树
                return true;
            }
            if( Math.abs(treeDepth(root.left)  - treeDepth(root.right)) <= 1 ) {
                //满足左右子树高度差小于等于1,那就接着判断左右子树是不是二叉树
                return (IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right));
            } else {
                //不满足左右子树高度差小于等于1,那这棵树肯定不是平衡二叉树啦
                return false;
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
            IsBalanced_Solution(list);
        }
    }
}
