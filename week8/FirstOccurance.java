//classic binary search version
public int firstOccur(int[] array, int target) { //ACed
  if(array == null || array.length == 0) return -1;
  int left = 0, right = array.length - 1, mid = left + (right - left) / 2;

  while(left < right) {
    if(array[mid] == target){
      right = mid;
    }
    else if(array[mid] > target) {
      right = mid - 1;
    }
    else{
      left = mid + 1;
    }
    mid = left + (right - left) / 2;
  }
  return array[mid] == target ? mid : -1;
}
