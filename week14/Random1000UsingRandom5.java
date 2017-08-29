public int random1000() {
  int random3000;
  do {
    random3000 = 0;
    for (int i = 0; i < 5; i++) {
      random3000 = 5 * random3000 + RandomFive.random5();
    }
  }
  while (random3000 >= 3000);

  return random3000 % 1000;
}

private static class RandomFive {
  public static int random5() {
    return (int) (Math.random() * 5);
  }
}
