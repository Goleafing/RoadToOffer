package baseDataStructure;

/**
 * @author leaf
 * @date 2019-8-31 10:59
 */

import java.util.Scanner;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class ReconstructBinaryTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] pre = new int[num];
        int[] in = new int[num];
        for(int i = 0; i < num; i++){
            pre[i] = sc.nextInt();
        }
        for(int i = 0; i < num; i++){
            in[i] = sc.nextInt();
        }

        ReconstructBinaryTree tree = new ReconstructBinaryTree();
        TreeNode re = tree.reconstructMethod(pre,in);
    }

    /**
     * 重构二叉树
     * @param pre 前序遍历数组
     * @param in  中序遍历数组
     * @return    返回重构好的二叉树
     */
    private TreeNode reconstructMethod(int[] pre, int[] in){
        TreeNode root = reconstructMethodCore(pre, 0, pre.length - 1,
                                                in, 0, in.length - 1);
        return root;
    }

    /**
     * 重构二叉树核心方法
     * @param pre
     * @param startPre
     * @param endPre
     * @param in
     * @param startIn
     * @param endIn
     * @return
     */
    private TreeNode reconstructMethodCore(int[] pre, int startPre, int endPre,
                                                    int[] in, int startIn, int endIn) {
        //如果开始位置没有在结束位置之前，表明该节点下面为空
        if(startPre > endPre || startIn > endIn){
            return null;
        }
        //前序遍历数组的开始节点为重构后的二叉树的根节点
        TreeNode root = new TreeNode(pre[startPre]);

        for(int i = startIn; i <= endIn; i++){
            if(in[i] == pre[startPre]){
                root.left = reconstructMethodCore(pre, startPre + 1, startPre + i - startIn,
                                                    in, startIn, i - startIn);
                root.right = reconstructMethodCore(pre,startPre+i-startIn + 1, endPre,
                                                    in, i + 1, endIn);
                break;
            }
        }
        return root;
    }


}
