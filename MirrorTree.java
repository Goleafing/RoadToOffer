/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */

public class MirrorTree{
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        public TreeNode(int val) {
            this.val = val;
    
        }
 
    }

    //
        /* 
        public void Mirror(TreeNode root) {
        if(root != null){
            TreeNode mirrorTree = new TreeNode();
            TreeNode tempTreeNode = root;
            mirrorTree.val = root.val;
            while(root != null){
                mirrorTree.left = root.right;
                mirrorTree = mirrorTree.left;
                root = root.right;
            }
            while(tempTreeNode != null){
                mirrorTree.right = tempTreeNode.left;
                mirrorTree = mirrorTree.left;
                tempTreeNode = tempTreeNode.left;
            }
            return mirrorTree;
        } */
        public void Mirror(TreeNode root) {
            TreeNode temp;
            if(root != null){
                temp = root.left;
                root.left = root.right;
                root.right = temp;
                if(root.left != null){
                    Mirror(root.left);
                }
                if(root.right != null){
                    Mirror(root.right);
                }
            }
        }
}