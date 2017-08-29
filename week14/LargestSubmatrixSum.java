public int largest(int[][] matrix) {
  //assumption: The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
  if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    return 0;
  }
  int row = matrix.length, col = matrix[0].length;

  //pre-fix sum for each column in the matrix
  for (int i = 1; i < row; i++) {
    for (int j = 0; j < col; j++) {
      matrix[i][j] += matrix[i - 1][j];
    }
  }

  int max = matrix[0][0];
  int[] temp = new int[col];

  for (int i = 0; i < row; i++) { //upperbound of the selected matrix
    for (int j = i; j < row; j++) { //lower bound of the selected matrix
      sumSubmatrix(matrix, temp, i, j);
      max = Math.max(max, largestSum(temp));
    }
  }

  return max;
}

private int largestSum(int[] array) {
  //assumption: The given array is not null and has length of at least 1
  int max = array[0];
  int prev = array[0];

  for (int i = 1; i < array.length; i++) {
    if (prev > 0) {
      prev += array[i];
    } else {
      prev = array[i];
    }
    max = Math.max(max, prev);
  }
  return max;
}

private void sumSubmatrix(int[][] matrix, int[] array, int top, int bottom) {
  for (int i = 0; i < array.length; i++) {
    array[i] = top == 0 ? matrix[bottom][i] : matrix[bottom][i] - matrix[top - 1][i];
  }
}
