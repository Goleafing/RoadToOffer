import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmetricalTree{
    class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }
    }
    /**
     * 思路：
     * 首先根节点以及其做哟字数，左子树的左子树和右子树的右子树相同
     * 左子树的右子树和右子树的左子树相同，采取递归
     * 非递归，采取栈或者队列存取各级子树根节点
     * 
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null){
            return true;
        }
        return rootCore(pRoot.left, pRoot.right);
    }
    private boolean rootCore(TreeNode left, TreeNode right){
        //如果左子树为空判断右子树是否为空，若为空返回true，不为空返回false
        if(left == null){
            return right == null;
        }
        //左子树不为空，右子树为空，返回false
        if(right == null){
            return false;
        }
        //左右子树均不为空，如果节点不相等返回false
        if(left.val != right.val){
            return false;
        }
        //进行递归，由于是镜像，则比较左子树的右子树与右子树的左子树 和左子树的左子树与右子树的右子树
        return rootCore(left.right, right.left) && rootCore(left.left, right.right);
    }

    //非递归算法，利用DFS(Depth-First-Search)和BFS(Breadth First Search)
    /**
     * DFS使用stack保存成对的节点
     * 出栈的时候也是成对成对的
     *  1.若都为空，继续
     *  2.一个为空返回false
     *  3.不为空，比较当前值，值不相等返回false
     * 确定入栈顺序，每次入栈都是成对成对的，如left.left, right.right
     */
    boolean isSymmetricalByDFS(TreeNode pRoot){
        if(pRoot == null){
            return false;
        }
        Stack<TreeNode> sTreeNodes = new Stack<>();
        sTreeNodes.push(pRoot.left);
        sTreeNodes.push(pRoot.right);
        while(!sTreeNodes.empty()){
            TreeNode right = sTreeNodes.pop();
            TreeNode left = sTreeNodes.pop();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            //成对插入
            sTreeNodes.push(left.left);
            sTreeNodes.push(right.right);
            sTreeNodes.push(left.right);
            sTreeNodes.push(right.left);
        }
        return true;
    }

    /**
     * BFS使用Queue来保存成对的节点，代码和上面极其相似
     * 1.出队的时候也是成对成对的 
            1.若都为空，继续；
            2.一个为空，返回false;
            3.不为空，比较当前值，值不等，返回false；
     * 2.确定入队顺序，每次入队都是成对成对的，如left.left， right.right ;left.rigth,right.left
     */
    boolean isSymmetricalByBFS(TreeNode pRoot){
        if(pRoot == null){
            return true;
        }
        Queue<TreeNode> qTreeNodes = new LinkedList<>();
        qTreeNodes.offer(pRoot.left);
        qTreeNodes.offer(pRoot.right);
        while(!qTreeNodes.isEmpty()){
            TreeNode left = qTreeNodes.poll();
            TreeNode right = qTreeNodes.poll();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            //成对插入
            qTreeNodes.offer(left.left);
            qTreeNodes.offer(right.right);
            qTreeNodes.offer(left.right);
            qTreeNodes.offer(right.left);
        }
        return true;
    }
}