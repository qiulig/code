package yunqiu.jianzhi_offer.tree;

import java.util.ArrayList;

/**从上到下打印二叉树
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Main_22_从上到下打印二叉树 {
     public static class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }
     }
    public static class Solution {
        public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            //创建一个列表用来存储节点
            ArrayList<TreeNode> treelist=new ArrayList<TreeNode>();
            ArrayList<Integer> intlist=new ArrayList<Integer>();

            if(root==null)  //没有节点
                return intlist;
            //1.先存入根节点
            treelist.add(root);
            //2.循环遍历列表，一开始列表里存了root
            for(int i=0;i<treelist.size();i++)
            { TreeNode node=treelist.get(i);
                //3.如果左子节点不为空，则将节点加入列表
                if(node.left!=null)
                    treelist.add(node.left);
                //3、如果右子节点不为空，则将右子节点加入到列表中，这时列表的size加1
                if(node.right!=null)
                    treelist.add(node.right);

                intlist.add(node.val);
                //4、因为执行上面操作后会增加列表的si
                //因此可以继续循环下一个节点，直到循环完所有节点
            }
            return intlist;
        }

        public static void main(String[] args) {
            TreeNode list = new TreeNode(8);
            list.left = new TreeNode(6);
            list.right = new TreeNode(10);
            list.left.left = new TreeNode(5);
            list.left.right =new TreeNode(7);
            list.right.left = new TreeNode(9);
            list.right.right = new TreeNode(11);
            ArrayList<Integer> res = Solution.PrintFromTopToBottom(list);
//            for(int s:res){
//                System.out.print(s+" ");
//            }
            res.forEach(System.out::print);
        }
    }
}
