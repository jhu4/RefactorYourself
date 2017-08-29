public int random7() {
  int random21;
  do {
    random21 = 5 * RandomFive.random5() + RandomFive.random5();
  }
  while (random21 >= 21);

  return random21 % 7;
}


private static class RandomFive {
  public static int random5() {
    return (int) (Math.random() * 5);
  }
}
