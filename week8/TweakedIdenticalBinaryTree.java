public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
  if(one == null && two == null) {
    return true;
  }
  if(one == null || two == null) {
    return false;
  }
  
  //java operator precedence is important, don't forget to put parentheses in the conditional statement
  return one.key == two.key
          && ((isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right))
          || (isTweakedIdentical(one.right, two.left) && isTweakedIdentical(one.left, two.right)));
}
