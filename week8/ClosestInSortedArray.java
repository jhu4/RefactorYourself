public class Solution {
  public int closest(int[] array, int target) {
    if(array == null || array.length == 0) return -1;

    int left = 0, right = array.length - 1, mid = left + (right - left) / 2;
    while(left < right - 1) { // stop at left = right - 1... also covers the edge case where array.length == 1
      if(array[mid] <= target) {
        left = mid; // mid - 1 is wrong because mid could be the possible candidate
      }
      else{
        right = mid; // mid +1 is wrong because mid could be the possible candidate
      }
      mid = left + (right - left) / 2;
    }
    return Math.abs(target - array[left]) < Math.abs(target - array[right]) ? left : right;
  }
}
