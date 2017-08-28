public int longest(int[] array) {
  if (array.length == 0) {
    return 0;
  }

  int max = 1;
  int cur = 1; //cur represent the ascending sub array including the i-th element (dp[i])
  //dp[i] = 1   (array[i] <= array[i - 1])
  //        dp[i - 1] + 1 (array[i] > array[i - 1])
  for (int i = 1; i < array.length; i++) {
    if (array[i] > array[i - 1]) {
      cur++;
      max = Math.max(cur,max);
    } else {
      cur = 1;
    }
  }

  return max;
}
