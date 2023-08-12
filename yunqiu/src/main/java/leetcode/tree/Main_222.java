package leetcode.tree;
//执行用时 :1 ms, 在所有 Java 提交中击败了90.07%的用户
// 内存消耗 :45.4 MB, 在所有 Java 提交中击败了35.21%的用户
public class Main_222 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static int countNodes(TreeNode root) {

        if(root==null){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right +1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(18);
        System.out.println(countNodes(root));
    }
}
