/**
  Assumption:
    1. matrix is not null
    2. 0 < k < N*M
    3. There is no Integer.MAX_VALUE in the matrix
**/
public int kthSmallest(int[][] matrix, int k) {
  int rowSize = matrix.length;
  int colSize = matrix[0].length;

  PriorityQueue<MyInt> pq = new PriorityQueue<>();
  pq.offer(new MyInt(0, 0, matrix[0][0]));

 for(int i = 0; i < k - 1; i++) {
    MyInt curMin = pq.poll();

    int row = curMin.row, col = curMin.col;
    int nextRow = row + 1, nextCol = col + 1;

    if(nextRow < rowSize && matrix[nextRow][col] != Integer.MAX_VALUE) { //if this element is not visited
      pq.offer(new MyInt(nextRow, col, matrix[nextRow][col]));
      matrix[nextRow][col] = Integer.MAX_VALUE; //mark as visited
    }

    if(col + 1 < colSize && matrix[row][col + 1] != Integer.MAX_VALUE) {
      pq.offer(new MyInt(row, nextCol, matrix[row][nextCol]));
      matrix[row][nextCol] = Integer.MAX_VALUE; //mark as visited
    }
  }

  return pq.poll().value;
}

public class MyInt implements Comparable<MyInt> {
  int row;
  int col;
  int value;

  public MyInt(int row, int col, int value) {
    this.row = row;
    this.col = col;
    this.value = value;
  }

  @Override
  public int compareTo(MyInt other) {
    if(this.value < other.value) {
      return -1;
    }
    else if(this.value == other.value) {
      return 0;
    }
    else {
      return 1;
    }
  }
}
