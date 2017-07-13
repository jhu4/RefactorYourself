//iterative solution
public List<Integer> inOrder(TreeNode root) {
  List<Integer> res = new LinkedList<>();
  if(root == null) {
    return res;
  }


  Deque<TreeNode> stack = new ArrayDeque<>();
  stack.push(root);
  root = root.left;

  while(!stack.isEmpty() || root != null) {
    while(root != null) { //adding all left sub-trees' nodes
      stack.push(root);
      root = root.left;
    }

    TreeNode tn = stack.pop();
    res.add(tn.key);
    root = tn.right;
  }

  return res;
}
