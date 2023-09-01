package leetcode.Arrays.动态规划;

import java.util.HashMap;

/**
 * Created by qiulig on 2023/9/1
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
public class Main_337_打家劫舍3 {

    static HashMap<TreeNode, Integer> map = new HashMap<>();


    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int rob(TreeNode root) {
        //map用于避免重复计算某节点
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (root == null) {
            return 0;
        }
        // 包含根节点的最大收益 = 根节点 + 左子树的儿子节点的最大收益 + 右子树的儿子节点的最大收益
        int maxNumExcludedRoot = root.val;
        if (root.left != null) {
            maxNumExcludedRoot += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            maxNumExcludedRoot += rob(root.right.left) + rob(root.right.right);
        }
        // 不包含根节点的最大收益 = 左子树的最大收益 + 右子树最大收益
        int maxNumContainsRoot = rob(root.left) + rob(root.right);
        int maxNum = Math.max(maxNumContainsRoot, maxNumExcludedRoot);
        map.put(root, maxNum);
        return maxNum;

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(1);
        System.out.println(rob(treeNode));
    }
}