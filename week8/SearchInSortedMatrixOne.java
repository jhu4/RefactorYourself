public int[] search(int[][] matrix, int target) {
  if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
    return new int[]{-1, -1};
  }

  int left = 0, right = matrix.length - 1, mid = left + (right - left) / 2;

  //binary search to find the closet smaller start element of rows to the target
  while(left < right - 1) {
    int rowElement = matrix[mid][0];
    if(rowElement < target) {
      left = mid;
    }
    else if(rowElement == target) {
      return new int[]{mid, 0};
    }
    else {
      right = mid - 1;
    }
    mid = left + (right - left) / 2;
  }

  int rowIndex;
  if(left == right) { //case 1: where left and right is pointing the same element
    rowIndex = left;
  }
  else if(matrix[right][0] < target) { //case 2: right is the largest smaller element to the target
    rowIndex = right;
  }
  else if(matrix[right][0] == target){
    return new int[]{right, 0};
  }
  else { //case 3: left is the largest smaller element to the target
    rowIndex = left;
  }


  left = 0;
  right = matrix[rowIndex].length - 1;
  mid = left + (right - left) / 2;

  //binary search in the row to find the position of the target
  while(left <= right) {
    int middleNum = matrix[rowIndex][mid];
    if(middleNum == target) {
      return new int[]{rowIndex, mid};
    }
    else if(middleNum < target) {
      left = mid + 1;
    }
    else {
      right = mid - 1;
    }
    mid = left + (right - left) / 2;
  }

  return new int[]{-1, -1};
}
