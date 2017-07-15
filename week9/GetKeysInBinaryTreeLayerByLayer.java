public List<List<Integer>> layerByLayer(TreeNode root) {
  if(root == null) {
    return new LinkedList<>();
  }

  List<List<Integer>> outerList = new LinkedList<>();

  Queue<TreeNode> q = new LinkedList<>();
  q.offer(root);

  while(!q.isEmpty()) {
    int size = q.size();
    List<Integer> innerList = new LinkedList<>();

    for(int i = 0; i < size; i++) {
      TreeNode tn = q.poll();
      innerList.add(tn.key);

      if(tn.left != null) {
        q.offer(tn.left);
      }

      if(tn.right != null) {
        q.offer(tn.right);
      }
    }
    outerList.add(innerList); //don't forget to add inner list to the outer list at the end of the loop
  }

  return outerList;
}
