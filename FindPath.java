import java.util.ArrayList;

import JudgeSonTreeSolution.TreeNode;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath{
    //listAll存放所有找到的路径
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    //list为单个的路径
    private ArrayList<Integer> list = new ArrayList<Integer>();
    //寻找路径函数
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target){
        //如果root节点为空，返回listAll
        if(root == null){
            return listAll;
        }
        //向单个路径中添加节点元素
        list.add(root.val);
        //减去添加过的节点
        target -= root.val;
        //判断target是否为空，如果以下判断条件为空代表找到一条路径
        if(target == 0 && root.left == null && root.right == null){
            listAll.add(new ArrayList<Integer>(list));
        }
        //递归，在左子树继续寻找
        findPath(root.left, target);
        //递归，在右子树寻找
        findPath(root.right, target);
        //为什么要加这一步呢？？因为这一步表示的是找到的路径的和不等于target，
        //把最后一个元素删除
        list.remove(list.size() - 1);
        //返回所有的路径
        return listAll;
    }
}
