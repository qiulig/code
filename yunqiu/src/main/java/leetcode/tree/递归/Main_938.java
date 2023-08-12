package leetcode.tree.递归;
//执行用时 :3 ms, 在所有 Java 提交中击败了48.66%的用户
//内存消耗 :53.1 MB, 在所有 Java 提交中击败了32.11%的用户
public class Main_938 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    static int num = 0;
    public static int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null)
            return 0;
       if(root!=null){
           rangeSumBST(root.left,L,R);
           if(root.val >=L && root.val<=R){
               num +=root.val;
           }
           rangeSumBST(root.right,L,R);
       }
       return num;
    }

    public static void main(String[] args) {
//        输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
//        输出：32
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root,7,15));
    }
}
