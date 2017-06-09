/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraverseTwoSolution {
    //Initial solution: using a queue and null to traverse the tree in level order
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        ArrayList<Integer> curArray=new ArrayList<>();
        
        while(q.size()>0){
            TreeNode curNode=q.poll();
            if(curNode==null){
                res.add(0,curArray);
                if(q.size()>0){ //only if there are other Node left in the queue
                    curArray=new ArrayList<>();
                    q.offer(null);
                }
            }
            else{
                curArray.add(curNode.val);
                if(curNode.left!=null) q.offer(curNode.left);
                if(curNode.right!=null) q.offer(curNode.right);
            }
        }
        return res;
    }
}
