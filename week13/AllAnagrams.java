List<Integer> allAnagrams(String s, String l) {
  List<Integer> list = new LinkedList<>();
  if (s.length() > l.length()) {
    return list;
  }

  Map<Character, Integer> map = new HashMap<>();
  //record how many distinct characters have been matched
  //if match == map.size() we find an anagram
  int match = 0;

  //the map records the distinct characters in s and how many characters are needed
  for (char c : s.toCharArray()) {
    Integer temp = map.get(c);
    if (temp == null) {
      map.put(c, 1);
    } else {
      map.put(c, temp + 1);
    }
  }

  //we have a sliding window of the size s.length()
  //we move the sliding window each time and do
  //1. remove the leftmost character in the previous window
  //2. add the rightmost character in the current window
  for (int i = 0; i < l.length(); i++) {
    char c = l.charAt(i);
    Integer val = map.get(c);

    //we add the new character
    if (val != null) {
      map.put(c, val - 1);
      if (val - 1 == 0) {
        match++;
      }
    }

    //delete the character
    if (i >= s.length()) {
      c = l.charAt(i - s.length());
      val = map.get(c);
      if (val != null) {
        map.put(c, val + 1);
        if (val == 0) {
          match --;
        }
      }
    }

    if (map.size() == match) {
      list.add(i + 1 - s.length());
    }
  }
  return list;
}
