//A cleaner solution
public String hex(int number) {
  if (number == 0) {
    return "0x0";
  }

  String prefix = "0x";
  StringBuilder sb = new StringBuilder();

  while(number != 0) {
    int value = number % 16;
    if (value < 10) {
      sb.append((char)(value + '0'));
    } else {
      sb.append((char)(value - 10 + 'A'));
    }
    number >>>= 4;
  }

  return prefix + sb.reverse().toString();
}

//my initial solu
public String hex(int number) {
  if (number == 0) {
    return "0x0";
  }

  char[] array = new char[8];
  int counter = 0;
  while (number != 0) {
    int value = number - (number & (~15));
    number >>>= 4;
    array[counter++] = intToHex(value);
  }

  StringBuilder sb = new StringBuilder("0x");
  for (int i = counter - 1; i >= 0; i--) {
    sb.append(array[i]);
  }

  return sb.toString();
}

private char intToHex(int number) {
  if (number <= 9) {
    return (char) (number + '0');
  } else if (number == 10) {
    return 'A';
  } else if (number == 11) {
    return 'B';
  } else if (number == 12) {
    return 'C';
  } else if (number == 13) {
    return 'D';
  } else if (number == 14) {
    return 'E';
  } else {
    return 'F';
  }
}
