/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalacedBinaryTreeSolution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        
        return isBalancedTree(root)!=-1;
    }
    
    private int isBalancedTree(TreeNode root){
        if(root==null) return 0;
        
        int left=isBalancedTree(root.left);
        if(left==-1) return -1;
        
        int right=isBalancedTree(root.right);
        if(right==-1) return -1;
        
        return Math.abs(left-right)<=1?1+Math.max(left,right):-1;
    }
}
