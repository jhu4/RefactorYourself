public int minCuts(String input) {
  int len = input.length();
  int[] minCuts = new int[len + 1];
  boolean[][] isPalindrome = new boolean[len + 1][len + 1];

/* minCuts[i] represents the min cut of making substring(0, i) exclusive of i-th
    character
    base case: minCuts[0] = 0
               minCuts[1] = 0
    induction: minCuts[i] =   0   (substring(0, i) is palindromic)
                              min(minCuts[n] + 1)  (substring (n, i) is palindromic AND 0 <= n <= i)

  isPalindrome[s][e] represents whether substring (s, e) is a palindrome
  basecase: isPalindrome[s[e + 1] = true
            isPalindrome[s][e] = true   (if char[s] = char[e - 1] and isPalindrome[s + 1][e - 1] = true)
                                 true   (if char[s] = char[e] and e - s = 2)
                                 false  (otherwise)
*/

  for (int end = 1; end < len + 1; end++) { //end index of minCut substring
    minCuts[end] = end - 1; //initialization
    for (int start = end - 1; start >= 0; start--) {
      if(start == end - 1) {
        isPalindrome[start][end] = true;
      } else if (input.charAt(start) == input.charAt(end - 1)) {
        if (end - start == 2 || isPalindrome[start + 1][end - 1]) {
          isPalindrome[start][end] = true;
        }
      }

      if (isPalindrome[start][end]) {
        minCuts[end] = Math.min(minCuts[end], minCuts[start] + 1);
      }
    }
    if (isPalindrome[0][end]) {
      minCuts[end] = 0;
    }
  }

  return minCuts[len];
}
