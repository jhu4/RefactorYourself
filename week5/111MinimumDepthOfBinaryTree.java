/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinimumDepthOfBinaryTreeSolution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        
        return min(root);
    }
    
    private int min(TreeNode root){
        if(root.left==null&&root.right==null) return 1;
        else if(root.left==null) return 1+min(root.right);
        else if(root.right==null) return 1+min(root.left);
        else return 1+Math.min(min(root.left),min(root.right));
    }
}
