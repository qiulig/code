package yunqiu.jianzhi_offer.tree;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Main_4_重建二叉树 {
    //树的构建
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public static class Solution {
        public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
            if(pre.length==0 || in.length==0)
                return null;
            TreeNode node = new TreeNode(pre[0]);	//根结点
            for(int i=0;i<pre.length;i++){
                if(pre[0] == in[i]){	 //找到根节点在中序遍历的点，左边为根的左节点，右边为根的右节点
                    //递归调用构建当前节点的左子树
                    node.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                    //递归调用构建当前节点的右子树
                    node.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                    break;
                }
            }
            return node;
        }
    }

    public static void main(String[] args) {
        int pre[] = {1,2,4,7,3,5,6,8};
        int in[] = {4,7,2,1,5,3,8,6};
        TreeNode node =  Solution.reConstructBinaryTree(pre,in);
        postprint(node);
    }
    public static void postprint(TreeNode node){
          if(node!=null)
          {
              postprint(node.left);
              postprint(node.right);
              System.out.print(node.val+" ");
          }
    }
}
