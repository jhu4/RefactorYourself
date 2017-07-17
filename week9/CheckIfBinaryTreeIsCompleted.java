public boolean isCompleted(TreeNode root) {
  if(root == null) {
    return true;
  }

  boolean haveSeenNull = false;
  Queue<TreeNode> q = new LinkedList<>();
  q.offer(root);

  while(!q.isEmpty()) {
    TreeNode tn = q.poll();

    if(tn == null && !haveSeenNull) { //we see the first null
      haveSeenNull = true;
    }

    if(tn != null) {
      if(haveSeenNull) { //if see node after first null, then it's not a complete tree
        return false;
      }
      
      q.offer(tn.left);
      q.offer(tn.right);
    }
  }

  return true;
}
