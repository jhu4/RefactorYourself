//dp from the back to the front
public boolean canJump(int[] array) {
/*
  base case:
  dp[end] = true

  dp[n] represent whether we can jump from n-th position to the end
  dp[n] = true (dp[n + 1] ~ dp[n + jumpStep] had one true)
           false (otherwise)

*/
  boolean[] dp = new boolean[array.length];
  dp[array.length - 1] = true;

  for (int i = array.length - 2; i >= 0; i--) {
    int upperBound = Math.min(array.length - 1, i + array[i]);
    for (int j = i + 1; j <= upperBound; j++) {
      if (dp[j]) {
        dp[i] = true;
      }
    }
  }

  return dp[0];
}
