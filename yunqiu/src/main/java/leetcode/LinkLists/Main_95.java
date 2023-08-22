package leetcode.LinkLists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main_95 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public static List<TreeNode> generateTrees(int n) {
            List<TreeNode> res = new LinkedList<>();
            if (n == 0)
                return res;
            return generateTrees(1, n);
        }

        static private List<TreeNode> generateTrees(int start, int end) {
            //n = 1 的情况，只有一个，就是根节点为1的二叉搜索树
            if (start == end) {
                List<TreeNode> list = new ArrayList<>();
                TreeNode node = new TreeNode(start);
                list.add(node);
                return list;
            }
            //以 i 为根节点，左子树为start~(mid-1),右子树为(mid+1)~n
            List<TreeNode> res = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = new ArrayList<>();
                List<TreeNode> right = new ArrayList<>();
                if (i != start) {
                    //说明有左子树
                    left = generateTrees(start, i - 1);
                }
                if (i != end) {
                    //说明有右子树
                    right = generateTrees(i + 1, end);
                }
                if (!left.isEmpty() && !right.isEmpty()) {
                    for (TreeNode l : left) {
                        for (TreeNode r : right) {
                            TreeNode root = new TreeNode(i);
                            root.left = l;
                            root.right = r;
                            res.add(root);
                        }
                    }
                } else if (!left.isEmpty()) {
                    for (TreeNode l : left) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        res.add(root);
                    }
                } else if (!right.isEmpty()) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(i);
                        root.right = r;
                        res.add(root);
                    }
                }
            }
            return res;
        }

        public static void main(String[] args) {
            List<TreeNode> res = generateTrees(3);
        }
    }
}
