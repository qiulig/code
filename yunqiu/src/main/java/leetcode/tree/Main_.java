package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_ {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    static class solution {
        //深度优先遍历
        public static ArrayList<Integer> DFS(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null)
                return res;
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                //先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
                res.add(node.val);
            }
            return res;
        }
        static ArrayList<Integer> ans = new ArrayList();
        public static ArrayList<Integer> DeepFS(TreeNode root) {
            if (root != null) {
                ans.add(root.val);
                DeepFS(root.left);
                DeepFS(root.right);
            }
            return ans;
        }
        public static ArrayList<Integer> BFS(TreeNode root) {
          ArrayList<Integer> res = new ArrayList<>();
          if(root == null)
              return res;
          Queue<TreeNode> queue = new LinkedList<>();
          queue.add(root);
          while (!queue.isEmpty()){
              TreeNode node = queue.poll();
              if(node.left!=null)
                  queue.add(node.left);
              if(node.right!=null)
                  queue.add(node.right);
              res.add(node.val);
          }
          return res;
        }
        static int maxLength = 0;
        public static int maxDepth(TreeNode root) {

            if(root!=null){
                if(root.left!=null ||root.right!=null) {
                    maxLength ++;
                    maxDepth(root.left);
                    maxDepth(root.right);

                }

            }
            return maxLength;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.right.left = new TreeNode(6);

//        ArrayList res = solution.DFS(root);
//        ArrayList res = solution.DeepFS(root);
//        ArrayList res = solution.BFS(root);
        System.out.println(solution.maxDepth(root));
//        for(int i = 0;i<res.size();i++){
//            System.out.print(res.get(i)+" ");
//        }
    }
}
