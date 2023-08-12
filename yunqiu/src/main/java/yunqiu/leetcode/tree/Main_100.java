package yunqiu.leetcode.tree;

public class Main_100 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q==null)
            return true;
        if(p==null ||q == null)
            return false;
        if(p.val !=q.val)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(1);
        root2.right.left = new TreeNode(5);
        System.out.println(isSameTree(root,root2));
    }
}
