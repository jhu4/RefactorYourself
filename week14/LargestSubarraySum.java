public int largestSum(int[] array) {
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
