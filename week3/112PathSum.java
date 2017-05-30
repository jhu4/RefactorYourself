/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumSolution {
    //recursive solution
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        
        if(root.left==null&&root.right==null) return sum==root.val;
        
        int num=sum-root.val;
        return hasPathSum(root.left,num)||hasPathSum(root.right,num);
    }
}
