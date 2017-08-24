//method 2: counting 1 in binary form
public boolean isPowerOfTwo(int number) {
  if (number <= 0) {
    return false;
  }

  int count = 0;
  while (number > 0) {
    count += number & 1;
    number >>= 1;
  }
  return count == 1;
}

//method 3: bit manipulation technique
public boolean isPowerOfTwoSmartWay(int number) {
  //if assume that the input is a positive number
  return number != 0 && (number & (number - 1)) == 0;
}
