public int maxProduct(int length) {
/* M[n] represents the max product of a cutting rope with length n
    M[1] = 0
    M[2] = 1
    M[n] = max {
                  max(M[1], 1) * (n - 1),
                  max(M[2], 2) * (n - 2),
                  ...
                  map(M[n-1], n - 1) * 1
    }
*/

  if (length <= 1) {
    return 0;
  }
  if (length == 2) {
    return 1;
  }


  int[] dp = new int[length + 1];
  dp[1] = 0;
  dp[2] = 1;

  for (int i = 3; i <= length; i++) {
    for (int j = 1; j < i; j++) { //Question here: why can the terminated condition be <= i/2
      dp[i] = Math.max(Math.max(j, dp[j]) * (i - j), dp[i]); // should be * (i - j) instead of * (length - j) because this is the subproblem
    }
  }

  return dp[length];
}
