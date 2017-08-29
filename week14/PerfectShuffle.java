public void shuffle(int[] array) {
  if (array.length <= 1) {
    return;
  }

  for (int i = array.length; i >= 1; i--) {
    swap(array, i - 1, (int) (Math.random() * i));
  }
}

private void swap(int[] array, int i, int j) {
  int temp = array[i];
  array[i] = array[j];
  array[j] = temp;
}
