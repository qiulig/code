package leetcode.tree;

import java.util.*;

public class Main_102 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
           ArrayList<Integer> tmp = new ArrayList<>();
           int count = queue.size();
           for(int i = 0; i<count;i++){
               TreeNode node = queue.poll();
               if(node.left!=null)
                   queue.add(node.left);
               if(node.right!=null)
                   queue.add(node.right);
               tmp.add(node.val);
           }
           lists.add(tmp);
        }
    return lists;
    }
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null)
            return ans;
        helper(root,0);
        return ans;
    }

    private void helper(TreeNode root, int level) {
        if(ans.size() == level)
            ans.add(new ArrayList<>());
        ans.get(level).add(root.val);

        if(root.left != null)
            helper(root.left,level+1);
        if(root.right != null)
            helper(root.right,level+1);
    }
}
