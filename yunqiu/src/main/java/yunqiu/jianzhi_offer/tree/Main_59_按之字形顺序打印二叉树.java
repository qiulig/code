package yunqiu.jianzhi_offer.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Main_59_按之字形顺序打印二叉树 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public static class Solution {
        public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
         if (pRoot == null) {
                 return result;
             }
         ArrayList<Integer> list = new ArrayList<>();
         LinkedList<TreeNode> queue = new LinkedList<>();
         queue.addLast(null);//层分隔符
         queue.addLast(pRoot);
         boolean leftToRight = true;
         while (queue.size() != 1) {
             TreeNode node = queue.removeFirst();
             if (node == null) {//到达层分隔符
                 Iterator<TreeNode> iter = null;
                 if (leftToRight) {
                        iter = queue.iterator();//从前往后遍历
                     } else {
                         iter = queue.descendingIterator();//从后往前遍历
                     }
                 leftToRight = !leftToRight;
                 while (iter.hasNext()) {
                         TreeNode temp = (TreeNode) iter.next();
                         list.add(temp.val);
                     }
                 result.add(new ArrayList<Integer>(list));
                 list.clear();
                 queue.addLast(null);//添加层分隔符
                 continue;//一定要continue
               }
             if (node.left != null) {
                     queue.addLast(node.left);
                 }
             if (node.right != null) {
                     queue.addLast(node.right);
                 }
             }
         return result;
     }

        public static void main(String[] args) {
            TreeNode list = new TreeNode(8);
            list.left = new TreeNode(6);
            list.right = new TreeNode(10);
            list.left.left = new TreeNode(5);
            list.left.right =new TreeNode(7);
            list.right.left = new TreeNode(9);
            list.right.right = new TreeNode(11);
            Print(list);
        }
    }
}
