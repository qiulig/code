package jianzhi_offer.tree;

/**
 * 二叉树的序列化和反序列化
 */
public class Main_61_序列化二叉树 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        public int index = -1;
        //室友递归先序遍历对二叉树进行序列化
        String Serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            if(root == null){
                sb.append("#,");
                return sb.toString();
            }
            //先序遍历根结点
            sb.append(root.val + ",");
            //左子树
            sb.append(Serialize(root.left));
            //右子树
            sb.append(Serialize(root.right));
            return sb.toString();
        }
        TreeNode Deserialize(String str) {
            //特殊输入
            if(str==null||str.length()<=0)
                return null;
            //将字符串按照","拆分为数组
            String[] strr = str.split(",");
            int len = strr.length;
            index++;
            if(index >= len){
                return null;
            }
            TreeNode node = null;
            //如果遇到的是#表示空节点，不再建立子树，这个结点null就是子树的根结点返回
            if(!strr[index].equals("#")){
                node = new TreeNode(Integer.valueOf(strr[index]));
                //恢复左子树
                node.left = Deserialize(str);
                //恢复右子树
                node.right = Deserialize(str);
            }
            //建立二叉树完成，返回根节点
            return node;
        }
    }
}
