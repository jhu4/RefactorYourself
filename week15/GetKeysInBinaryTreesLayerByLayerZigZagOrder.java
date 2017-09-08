public List<Integer> zigZag(TreeNode root) {
/*
  For even layer: poll from head
                  add children to tail (left child first)
  For odd layer: poll from tail
                 add children to head (right child first)
*/
  List<Integer> list = new LinkedList<Integer>();
  if (root == null) {
    return list;
  }
  Deque<TreeNode> deque = new ArrayDeque<>();
  deque.offer(root);
  int layNum = 1;

  while (deque.size() != 0) {
    int len = deque.size();
    TreeNode tn;
    for (int i = 0; i < len; i++) {
      if (layNum % 2 == 0) {
        tn = deque.poll();
        if (tn.left !=null) {
          deque.offer(tn.left);
        }
        if (tn.right != null) {
          deque.offer(tn.right);
        }
      } else {
        tn = deque.pollLast();
        if (tn.right != null) {
          deque.offerFirst(tn.right);
        }
        if (tn.left != null) {
          deque.offerFirst(tn.left);
        }
      }
      list.add(tn.key);
    }
    layNum++;
  }
  return list;
}
