package jianzhi_offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Main_60_把二叉树打印成多行 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
public class Solution {
   ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
       ArrayList<ArrayList<Integer>> res = new ArrayList<>();
       if(pRoot == null) {
           return res;
       }
       Queue<TreeNode> queue = new LinkedList<>();
       //加入根结点
       queue.add(pRoot);
       while (!queue.isEmpty()){
           //每遍历一次，就新建一次tmp
           ArrayList<Integer>  tmp = new ArrayList<>();
           int count = queue.size();
           for(int i = 0;i<count;i++){
               if(queue.peek().left!=null){
                   //加入左结点
                   queue.add(queue.peek().left);
               }
               if(queue.peek().right!=null){
                   //加入右结点
                   queue.add(queue.peek().right);
               }
               //删除并返回queue中的头元素，删掉根（上一层结点元素）
               tmp.add(queue.poll().val);
           }
           //将一层的左右结点加入res
           res.add(tmp);
       }
       return res;
    }
}

}
