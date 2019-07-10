/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class JudgeSonTreeSolution{

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        public TreeNode(int val) {
            this.val = val;
    
        }
 
    }

    /* public boolean HasSubTree(TreeNode root1,TreeNode root2){
        //判断root1与root2是否为空，如果root1为空，即A为空，返回false
        //如果root2为空，即B为空，根据约定空树不是任意一个树的子结构，返回false
        if(root1 == null || root2 == null){
            return false;
        }
        //首先判断root1和root2是否相等，然后判断是否为root1的左右子树的子树
        return isSame(root1,root2) || HasSubTree(root1.left, root2) || HasSubTree(root1.right, root2);
    } */

    //判断两个二叉树是否相等
    /* public boolean isSame(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val == root2.val){
            return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
        }else{
            return false;
        }
    } */
    public static boolean HasSubTree(TreeNode root1,TreeNode root2){
        boolean result = false;
        //当Tree1和tree2都不为空的时候，才进行比较。否则直接返回false
        if(root1 != null && root2 != null){
            //如果找到了对应tree2的根节点
            if(root1.val == root2.val){
                //以tree2的根节点为起点判断tree1是否包含tree2
                result = doesTree1HaveTree2(root1,root2);
            }
            //如果找不到根节点，那么就让root的左子树去当作起点，去判断是否包含tree2
            if(!result){
                result = doesTree1HaveTree2(root1.left,root2);
            }
            //如果找不到根节点，那么就让root的右子树去当作起点，去判断是否包含tree2
            if(!result){
                result = doesTree1HaveTree2(root1.right,root2);
            }
        }
        //返回结果
        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode node1,TreeNode node2) {
        //如果tree2已经遍历完了都能对应的上，返回true
        if(node2 == null){
            return true;
        }
        //如果tree2没有遍历完，tree1却遍历完了，那么返回false。
        if(node1 == null){
            return false;
        }
        //如果其中有一个点没有对上，那么返回false。
        if(node1.val != node2.val){
            return false;
        }
        //如果根节点对应的上，那么就分别去子节点里面分配
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }
}