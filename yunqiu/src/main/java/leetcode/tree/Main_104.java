package leetcode.tree;
public class Main_104 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class solution {
        public static int maxDepth(TreeNode root) {
            if (root != null) {
                int left_height = maxDepth(root.left);
                int right_height = maxDepth(root.right);
                return Math.max(left_height, right_height) + 1;
            } else {
                return 0;
            }
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.right = new TreeNode(6);
            root.left.left = new TreeNode(3);
            root.left.right = new TreeNode(1);
            root.right.left = new TreeNode(5);
            System.out.println(maxDepth(root));
        }
    }
}