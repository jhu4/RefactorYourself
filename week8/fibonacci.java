public long fibonacci(int k) { //AC
  if(k <= 0) return 0;
  if(k == 1) return 1;

  long prepre = 0, pre = 1;
  for(int i = 2; i <= k; i++) {
      long cur = prepre + pre;
      prepre = pre;
      pre = cur;
  }
  return pre;
}
