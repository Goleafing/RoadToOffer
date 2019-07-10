/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和
 * 中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class RebuildTreeSolution {
    

    //Definition for binary tree
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * 重构二叉树
     * @param pre 前序遍历数组
     * @param in  中序遍历数组
     * @return    返回重构好的二叉树
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in){
        TreeNode root = reConstructBinaryTree(pre,0,pre.length - 1,in,0,in.length - 1);
        return root;
    }

    /**
     * 
     * @param pre       前序遍历数组
     * @param startPre  前序遍历数组开始位置，开始节点
     * @param endPre    前序遍历数组结束位置，结束节点
     * @param in        中序遍历
     * @param startIn   中序遍历数组开始位置，开始节点
     * @param endIn     中序遍历数组结束位置，结束节点
     * @return          重构好的二叉树
     */
    private TreeNode reConstructBinaryTree(int[] pre,int startPre,int endPre,
                                            int[] in, int startIn,int endIn){
        //如果开始位置没有在结束位置前面，代表该节点下为空                                       
        if(startPre > endPre || startIn > endIn){
            return null;
        }
        //前序遍历数组的开始节点为重构后的二叉树的根节点
        TreeNode root = new TreeNode(pre[startPre]);

        //利用循环遍历每一个节点
        for(int i = startIn; i <= endIn; i++){
            if(in[i] == pre[startPre]){
                //找出左子树，然后递归
                root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                //找出右子树，然后递归
                root.right = reConstructBinaryTree(pre, startPre+i-startIn+1, endPre, in, i+1, endIn);
                //todo 为什么加一个break，增加代码的鲁棒性？？？
                break;
            }
        }
        return root;
    }
}