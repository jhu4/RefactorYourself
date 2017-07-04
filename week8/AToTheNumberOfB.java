//iteractive solution
public long power(int a, int b) { //ACed
  if(b == 0) return 1;
  if(a == 0) return 0;

  long base = a, result = 1;
  while(b > 1) {
    if(b % 2 != 0) {
      result *= base;
    }
    base *= base;
    b /= 2;
  }
  return result * base;
}

//Recursion solution... int a could be overflow...it would be better to have an exactly same fuction but use long instead
//of int
public long power(int a, int b) { //ACed
  if(b == 1) return a; // I almost forget this base case
  if(b == 0) return 1;
  if(a == 0) return 0;

  long breakdown = power(a * a, b / 2);

  return b % 2 == 0? breakdown : breakdown * a;
}

