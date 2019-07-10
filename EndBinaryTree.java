/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）
 * 它或者是一棵空树，或者是具有下列性质的二叉树： 
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，
 * 则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
 * 例如：
 *           4
 *         /   \
 *        2     6
 *       / \   / \
 *      1   3 5   7
 */
public class EndBinaryTree{
    public boolean VerifySequenceOfBST(int[] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return IsTreeBST(sequence,0,sequence.length - 1);
    }

    public boolean IsTreeBST(int[] sequence,int start,int end){
        if(end <= start){
            return false;
        }
        int i = start;
        //左子树情况
        for(; i < end; i++){
            if(sequence[i] > sequence[end]) break;
        }
        //右子树情况
        for(int j = i; j < end; j++){
            if(sequence[j] < sequence[end]) return false;
        }
        //递归判断左右子树是否为二叉搜索树
        return IsTreeBST(sequence, start, i - 1) && IsTreeBST(sequence, i, end - 1);
    }
}