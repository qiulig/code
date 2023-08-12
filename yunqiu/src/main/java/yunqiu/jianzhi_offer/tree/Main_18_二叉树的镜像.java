package yunqiu.jianzhi_offer.tree;

/**
 * ���������Ķ�����������任ΪԴ�������ľ���
 * �������ľ����壺
 *
 *                          8
 *
 *                       /      \
 *
 *                     6         10
 *
 *                   /   \     /    \
 *
 *                  5     7    9     11

 * ���������
 *
 *                         8
 *
 *                     /       \
 *
 *                  10             6
 *
 *                /    \         /    \
 *
 *              11      9       7       5
 * ԭ�����ӣ�https://blog.csdn.net/qq_17556191/article/details/94438182
 */
public class Main_18_�������ľ��� {
     public static class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;
     }
     }

    public static class Solution {
        public static void Mirror(TreeNode root) {
            if(root!=null&&(root.left!=null||root.right!=null)){
                TreeNode tem=root.left;
                root.left=root.right;
                root.right=tem;
                Mirror(root.left);
                Mirror(root.right);
            }

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
        Solution.Mirror(list);
        System.out.println();
    }
}
