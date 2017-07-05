public int[] kClosest(int[] array, int target, int k) {
  int left = 0, right = array.length - 1, mid = left + (right - left) / 2;
  int[] res = new int[k];

  while(left < right - 1) {
    if(array[mid] <= target) {
      left = mid;
    }
    else {
      right = mid;
    }
    mid = left + (right - left) / 2;
  }

  for(int i = 0; i < k; i++) {
    if(left < 0) { //prevent IndexOutOfBound case
      res[i] = array[right++];
    }
    else if(right >= array.length) { //prevent IndexOutOfBound case
      res[i] = array[left--];
    }
    else if(Math.abs(target - array[left]) < Math.abs(target - array[right])) {
      res[i] = array[left--];
    }
    else {
      res[i] = array[right++];
    }
  }
}
