//using k-sized max heap
public int[] kSmallest1(int[] array, int k) {
  if(array == null || array.length ==0 || k == 0) {
    return new int[0];
  }
  if( k >= array.length) {
    Arrays.sort(array);
    return array;
  }

  int counter = 0;
  PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  for(; counter < k; counter++) {
    maxHeap.offer(array[counter]);
  }

  for(; counter < array.length; counter++) {
    if(array[counter] < maxHeap.peek().intValue()) {
      maxHeap.poll();
      maxHeap.offer(array[counter]);
    }
  }

  int[] res = new int[k];
  for(int i = k - 1; i >= 0; i--) {
    res[i] = maxHeap.poll();
  }
  return res;
}

//using min heap... basically heapSort
public int[] kSmallest2(int[] array, int k) {
  if(array == null || array.length == 0) {
    return new int[0];
  }

  PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
  for(int i : array) {
    minHeap.offer(i);
  }

  int[] res = new int[k];
  for(int i = 0; i < k; i++) {
    res[i] = minHeap.poll();
  }
  return res;
}
