public boolean isBalanced(TreeNode root) {
  return isBalancedTree(root) >= 0;
}

private int isBalancedTree(TreeNode root) {
  if(root == null) {
    return 0;
  }

  int leftHeight = isBalancedTree(root.left);
  int rightHeight = isBalancedTree(root.right);

  if(leftHeight < 0 || rightHeight < 0) {
    return -1;
  }
  else if(Math.abs(leftHeight - rightHeight) <= 1){
    return 1 + Math.max(leftHeight, rightHeight); //Don't forget to add one to the height
  }
  else {
    return -1;
  }
}
