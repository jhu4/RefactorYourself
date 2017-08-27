//tail recursion
public boolean match(String input, String pattern) {
  return match(input.toCharArray(), pattern.toCharArray(), 0, 0);
}

public boolean match(char[] input, char[] pattern, int ip, int pp) {
  if (ip == input.length && pp == pattern.length) { //should be == instead of >= 
    return true;        //think about "a" and "3"
  }
  if (ip >= input.length || pp >= pattern.length) {
    return false;
  }


  if (pattern[pp] < '0' || pattern[pp] >'9') { //if char is not number
    if (pattern[pp] != input[ip]) {
      return false;
    } else {
      return match(input, pattern, ip + 1, pp + 1);
    }
  } else {
    int count = 0;
    while (pp < pattern.length && pattern[pp] >= '0' && pattern[pp] <= '9') {
      count *= 10;
      count += pattern[pp] - '0';
      pp++;
    }
    return match(input, pattern, ip + count, pp);
  }
}
