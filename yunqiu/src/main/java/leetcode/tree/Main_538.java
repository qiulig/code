package leetcode.tree;
//执行用时 :2 ms, 在所有 Java 提交中击败了96.50%的用户
//内存消耗 :44.9 MB, 在所有 Java 提交中击败了65.75%的用户
public class Main_538 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static int num = 0;
    //中序遍历结果为从小到大，要变成累加树，则中序遍历反过来相加变成节点值即可。
    public static TreeNode convertBST(TreeNode root) {
       if(root!=null)
       {
           //遍历右子树
           convertBST(root.right);
           //改变值，依次累加即可
           root.val = root.val+num;
           //存储上一层的值
           num = root.val;
           //遍历左子树
           convertBST(root.left);

       }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        convertBST(root);

    }
}
