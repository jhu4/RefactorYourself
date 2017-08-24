//a better one
public int longest1(String input) {
  Set<Character> hs = new HashSet<>();
  int longest = Integer.MIN_VALUE;
  int slow = 0, fast = 0;


  while (fast < input.length()) {
    if (hs.contains(input.charAt(fast))) {
      hs.remove(input.charAt(slow++));
    } else {
      hs.add(input.charAt(fast++));
      longest = Math.max(longest, fast - slow);
    }
  }
  return longest;
}

//Not so good one
public int longest2(String input) {
  Map<Character, Integer> map = new HashMap<>();
  int startIndex = 0;
  int max = Integer.MIN_VALUE;

  for (int i = 0; i < input.length(); i++) {
    Integer index = map.get(input.charAt(i));


    if (index != null && index >= startIndex) { //if the character is in the result substring
      startIndex = index + 1; //we update the new start index and exclude the previous character
    } else {
      max = Math.max(max, i + 1 - startIndex); 
    }

    map.put(input.charAt(i), i);
  }

  return max;
}
