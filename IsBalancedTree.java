import FindTreeDepth.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。\
 * 思路：
 * 平衡二叉树的定义是：左右子树的高度差不大于1
 * 
 */
public class IsBalancedTree{
    public boolean IsBalanced_Solution(TreeNode root){
        if(root == null){
            return false;
        }
        int left = TreeDepthByRecursive(root.left);
        int right = TreeDepthByRecursive(root.right);
        int result = Math.abs((left - right));
        if(result == 0 || result == 1){
            return true;
        }
        return false;
    }

    private int TreeDepthByRecursive(TreeNode pRoot){
        if(pRoot == null){
            return 0;
        }
        int left = TreeDepth(pRoot.left);
        int right = TreeDepth(pRoot.right);
        return Math.max(left, right) + 1;
    }
}