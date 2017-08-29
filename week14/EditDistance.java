public int editDistance(String one, String two) {
  /*
    M[i][j] represent the min steps to transfer from substring of one with first i letters to substring of two with first j letters

    base case: M[0][m] = m, M[n][0] = n, M[0][0] = 0
    induction rule:
              M[i][j] = M[i - 1][j - 1]  case 1: one.charAt(i) == two.charAt(j), do nothing
                        1 + M[i - 1][j - 1]   case 2: replace
                        1 + M[i - 1][j]    case 3: delete
                        1 + M[i][j - 1]   case 4: insert

                      = min (all cases above)
  */

  int len1 = one.length(), len2 = two.length();
  int[][] matrix = new int[len1 + 1][len2 + 1];

  for (int i = 0; i <= len1; i++) {
    matrix[i][0] = i;
  }
  for(int i = 0; i <= len2; i++) {
    matrix[0][i] = i;
  }

  for (int i = 1; i <= len1; i++) {
    for (int j = 1; j <= len2; j++) {
      if (one.charAt(i - 1) == two.charAt(j - 1)) {
        matrix[i][j] = min(matrix[i - 1][j - 1], //do nothing
                1 + matrix[i - 1][j], //insert
                1 + matrix[i][j - 1]); //delete
      } else {
        matrix[i][j] = 1 + min(matrix[i - 1][j - 1], //replace
                matrix[i - 1][j], //insert
                matrix[i][j - 1]); //delete
      }
    }
  }

  return matrix[len1][len2];
}

private int min(int a, int b, int c) {
  return Math.min(Math.min(a, b), c);
}
