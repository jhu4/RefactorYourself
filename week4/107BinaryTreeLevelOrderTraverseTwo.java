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
    
    //Or can use the size of the queue to determine the boundary of a layer
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        
        
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> curList=new ArrayList<>();
            TreeNode curNode;
            for(int i=0;i<size;i++){
                curNode=q.poll();
                if(curNode.left!=null) q.offer(curNode.left);
                if(curNode.right!=null) q.offer(curNode.right);
                curList.add(curNode.val);
            }
            res.add(0,curList);
        }
        return res;
    }
}
