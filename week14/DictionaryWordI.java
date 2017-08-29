public boolean canBreak(String input, String[] dict) {
  Set<String> hs = new HashSet<>();
  for (String s : dict) {
    hs.add(s);
  }

  /*
    canBreak[n] represents whether it can be broken down to words provided from 0 to n-th
    canBreak[n] = true (when canBreak[n - i] = true AND string.substring(i + 1) is in the dictionary)
                = false (otherwise)

  */
  boolean[] canBreak = new boolean[input.length()];
  canBreak[0] = hs.contains(input.substring(0,1));

  for (int i = 1; i < input.length(); i++) {
    canBreak[i] = hs.contains(input.substring(0, i + 1)); //initialized as not broken-down word
    for (int j = 0; j < i; j++) {
      if (canBreak[j] && hs.contains(input.substring(j + 1, i + 1))) {
        canBreak[i] = true;
        break;
      }
    }
  }

  return canBreak[input.length() - 1];
}
