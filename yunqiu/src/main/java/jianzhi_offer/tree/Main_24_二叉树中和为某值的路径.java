package jianzhi_offer.tree;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Main_24_二叉树中和为某值的路径 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        //创建一个类型为ArrayList<Integer>的list
        ArrayList<ArrayList<Integer>> pathlist=new ArrayList<ArrayList<Integer>>();
        //创建一个list,用于存放遍历的值
        ArrayList<Integer> path=new ArrayList<Integer>();
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
            //如果树为空，则返回空的pathlist
            if(root==null)
                return pathlist;
            //将root值放入list
            path.add(root.val);
            //如果根的左子树、右子树、目标值=根值，则返回path
            if(root.left==null&&root.right==null&&target==root.val)
            {
                pathlist.add(new ArrayList<Integer>(path));
            }
            //如果此时根值小于目标值并且含有左子树
            if(root.val<=target&&root.left!=null)
            {
                //将遍历左子树，将根设为左子树并且此时的target=target-遍历过的root值
                FindPath(root.left,target-root.val);
            }
            //如果此时根值小于目标值并且含有右子树
            if(root.val<=target&&root.right!=null)
            {
                //将遍历右子树，将根设为右子树并且此时的target=target-遍历过的root值
                FindPath(root.right,target-root.val);
            }
            //不论路径的值是否等于输入整数值，都要回退，
            //即使用remove函数移除路径上的最后一个节点。
            path.remove(path.size()-1);
            return pathlist;
        }
    }
}
