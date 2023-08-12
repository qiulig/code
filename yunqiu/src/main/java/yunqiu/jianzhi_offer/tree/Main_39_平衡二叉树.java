package yunqiu.jianzhi_offer.tree;

/**
 * ƽ�������
 * ����һ�ö��������жϸö������Ƿ���ƽ���������
 *
 * Ԥ��֪ʶ��ƽ���������һ �ÿ����������������������ĸ߶Ȳ�ľ���ֵ������1����������������������һ��ƽ���������
 * ˼�룺�Ӹ��ڵ㿪ʼ�����ж����������ĸ߶Ȳ��Ƿ񳬹�1��Ȼ������ж����������Ƿ���ƽ�������������õ��˵ݹ�˼�롣
 *
 */
public class Main_39_ƽ������� {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    //ƽ���������һ�ÿ����������������������ĸ߶Ȳ�ľ���ֵ������1
//��������������������һ��ƽ���������
    public static class Solution {
        public static  boolean IsBalanced_Solution(TreeNode root) {
            //һ�ÿ�������ƽ�������
            if(root==null){
                return true;
            }
            int left = treeDepth(root.left);
            int right = treeDepth(root.right);
            int diff = left - right;
            if(diff>1||diff<-1){
                return false;
            }
            return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
        }
        public static  int treeDepth(TreeNode root) {
            //----�ݹ�����������----
            if(root == null){
                return 0;
            }
            int left = treeDepth(root.left);
            int right = treeDepth(root.right);

            return (left>right)?(left+1):(right+1);
        }

        public boolean IsBalanced_Solution2(TreeNode root) {
            if( root == null) { //һ�ÿ�������ƽ�������
                return true;
            }
            if( Math.abs(treeDepth(root.left)  - treeDepth(root.right)) <= 1 ) {
                //�������������߶Ȳ�С�ڵ���1,�Ǿͽ����ж����������ǲ��Ƕ�����
                return (IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right));
            } else {
                //���������������߶Ȳ�С�ڵ���1,��������϶�����ƽ���������
                return false;
            }
        }
        public static void main(String[] args) {
            TreeNode list = new TreeNode(8);
            list.left = new TreeNode(6);
            list.right = new TreeNode(10);
            list.left.left = new TreeNode(5);
            list.left.right =new TreeNode(7);
            list.right.left = new TreeNode(9);
            list.right.right = new TreeNode(11);
            IsBalanced_Solution(list);
        }
    }
}
