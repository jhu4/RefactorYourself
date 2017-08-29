public int largest(int[][] matrix) {
/*
  dp[i][j][1] represent the longest consecutive 1s ending with coordinate[i][j] in up direction
  dp[i][j][2] represent the longest consecutive 1s ending with coordinate[i][j] in down direction
  dp[i][j][3] represent the longest consecutive 1s ending with coordinate[i][j] in left direction
  dp[i][j][4] represent the longest consecutive 1s ending with coordinate[i][j] in right direction

  dp[i][j][0] represent the longest cross of 1s centered on coordinate[i][j]

  dp[i][j][0] = min (dp[i][j][1], dp[i][j][2], dp[i][j][3], dp[i][j][4])
*/
  if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    return 0;
  }
  int row = matrix.length, col = matrix[0].length;
  int[][][] dp = new int[row][col][5];
  int max = 0;

  for (int i = 0; i < row; i++) {
    dp[i][0][4] = matrix[i][0];
    for (int j = 1; j < col; j++) { //right
      if (matrix[i][j] == 1) {
        dp[i][j][4] = 1 + dp[i][j - 1][4];
      }
    }
    dp[i][col - 1][3] = matrix[i][col - 1]; //left
    for (int j = col - 2; j >= 0; j--) {
      if (matrix[i][j] == 1) {
        dp[i][j][3] = 1 + dp[i][j + 1][3];
      }
    }
  }

  for (int j = 0; j < col; j++) {
    dp[0][j][2] = matrix[0][j];
    for (int i = 1; i < row; i++) { //down
      if (matrix[i][j] == 1) {
        dp[i][j][2] = 1 + dp[i - 1][j][2];
      }
    }
    dp[row - 1][j][1] = matrix[row - 1][j]; //up
    for (int i = row - 2; i >= 0; i--) {
      if (matrix[i][j] == 1) {
        dp[i][j][1] = 1 + dp[i + 1][j][1];
      }
    }
  }

  for (int i = 0; i < row; i++) {
    for (int j = 0; j < col; j++) {
      dp[i][j][0] = Math.min(Math.min(dp[i][j][1], dp[i][j][2]),
              Math.min(dp[i][j][3], dp[i][j][4]));
      max = Math.max(max, dp[i][j][0]);
    }
  }

  return max;
}
