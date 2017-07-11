
public boolean isSymmetric(TreeNode root) {
  if(root == null) {
    return true;
  }
  return isSymmetric(root.left, root.right);
}

private boolean isSymmetric(TreeNode left, TreeNode right) {
  if(left == null && right == null) {
    return true;
  }
  if(left == null || right == null) {
    return false;
  }

  boolean topValueEqual = left.key == right.key; //don't forget this step!!!
  return topValueEqual && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
}
