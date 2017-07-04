//classic binary search version
public int lastOccur(int[] array, int target) {
  if(array == null || array.length == 0) return -1;
  int left = 0, right = array.length - 1, mid = left + (right - left) / 2;

  while(left <= right) {
    if(array[mid] <= target) {
      left = mid + 1; //left is always point to the closet larger number
    }
    else {
      right = mid - 1;
    }
    mid = left + (right - left) / 2;
  }

  return (left - 1 < 0 || array[left - 1] != target) ? -1 : left - 1; // left could be zero
}
