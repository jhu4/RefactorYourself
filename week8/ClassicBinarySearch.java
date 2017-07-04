public int binarySearch(int[] array, int target) {
  if (array == null || array.length == 0) return -1;
  int left = 0, right = array.length - 1, mid = left + (right - left) / 2; //right should be len - 1

  while (left <= right) {
    if (array[mid] == target) return mid;
    else if (array[mid] < target) { //don't f**king use mid instead of array[mid]
      left = mid + 1;
    } else {
      right = mid - 1;
    }
    mid = left + (right - left) / 2; //don't f**king forget to calculate mid
  }

  return -1;
}
