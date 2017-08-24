public boolean allUnique(String word) {
  int[] bitmap = new int[8]; //bitmap

  for (char c: word.toCharArray()) {
    int row = c / 32; //it's c not c - 'c' because the range is the entire ASCII code
    int column = c % 32;
    int mask = 1 << (column - 1);

    if ((bitmap[row] & mask) != 0) { //if we had this character before
      return false;
    } else {
      bitmap[row] |= mask; //we mark on the bitmap
    }
  }

  return true;
}
