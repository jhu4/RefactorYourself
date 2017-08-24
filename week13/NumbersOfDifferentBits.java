public int diffBits(int a, int b) {
  int count = 0;
  for (int c = a ^ b; c != 0; c >>>= 1) { //>>> is a logical right shift, writing 0s into the leftmost bit
    count += c & 1;
  }

  return count;
}
