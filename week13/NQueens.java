public List<List<Integer>> nqueens(int n) {
  List<List<Integer>> result = new LinkedList<List<Integer>>();
  nqueens(result, new ArrayList<>(), n);
  return result;
}

public void nqueens(List<List<Integer>> result, List<Integer> prev, int n) {
  if (prev.size() == n) {
    result.add(new ArrayList<>(prev));
    return;
  }

  for (int i = 0; i < n; i++) { //this loop tries different column in this layer
    if (nqueensValidate(prev, i)) {
      prev.add(i);
      nqueens(result, prev, n);
      prev.remove(prev.size() - 1);
    }
  }
}

private boolean nqueensValidate(List<Integer> prev, int column) {
  int row = prev.size();
  for (int i = 0; i < row; i++) {
    int col = prev.get(i);
    //two queens cannot be in the same column OR two queens cannot be in a diagonal line
    if (col == column || Math.abs(col - column) == row - i) {
      return false;
    }
  }
  return true;
}
