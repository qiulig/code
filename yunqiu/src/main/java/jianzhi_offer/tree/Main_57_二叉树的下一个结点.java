package jianzhi_offer.tree;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Main_57_二叉树的下一个结点 {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public static class Solution {
        public TreeLinkNode GetNext(TreeLinkNode pNode)
        {
            if(pNode == null){
                return null;
            }
            //当前结点有右子树，那么它的下一个结点就是它的右子树中最左子结点
            if(pNode.right != null){
                pNode = pNode.right;
                while(pNode.left != null){
                    pNode = pNode.left;
                }
                return pNode;
            }
            // //// 当前结点无右子树，则需要找到一个是它父结点的左子树结点的结点
            while(pNode.next != null){
                if(pNode.next.left== pNode){
                    return pNode.next;
                }
                pNode = pNode.next;
            }
            return null;
        }
    }

        public static void main(String[] args) {
        }
    }
