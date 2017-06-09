/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedArrayToBinarySearchTreeSolution {
    //My initial recursion solution
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode res;
        if(nums==null||nums.length==0) return null;
        else if(nums.length==1)  return new TreeNode(nums[0]);
        else if(nums.length<=3){ //cover the base case
            res=new TreeNode(nums[1]);
            res.left=new TreeNode(nums[0]);
            if(nums.length==3) res.right=new TreeNode(nums[2]);
            return res;
        }
        
        res=new TreeNode(nums[nums.length/2]);
        res.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length/2));
        res.right=sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2+1,nums.length));
        return res;
    }
}
