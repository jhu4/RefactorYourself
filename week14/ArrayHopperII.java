//dp from back to the front
public int minJumpMyInitialSolution(int[] array) {
  int[] minjumps = new int[array.length];
  /* M[i] represents the number of min jumps from i to the target
      base case: M[target] = 0
      induction: M[i] = 1 + min(M[i], ..., M[i + jumpdistance])  (any reachable position can jump to the target)
                        0 (otherwise)

  */

  //initializing the array
  minjumps[array.length - 1] = 0;

  for (int i = array.length - 2; i >= 0; i--) {
    minjumps[i] = -1; //initialized as -1
    int min = Integer.MAX_VALUE;
    int exclusiveUpperBound = Math.min(i + array[i] + 1, array.length);
    for (int j = i; j < exclusiveUpperBound; j++) {
      if (minjumps[j] != -1) {
        min = Math.min(min, 1 + minjumps[j]);
      }
    }
    if (min != Integer.MAX_VALUE) {
      minjumps[i] = min;
    }
  }

  return minjumps[0];
}


//dp from the front to the back
public int minJump(int[] array) {
/*
  M[n] represents the minimum jumps from 0 t n

  base case: M[0] = 0
  induction: M[n] = min(1 + M[y])  (0 =< y < n AND we can jump from y to n)
                  = -1  otherwise
*/

  int[] minjumps = new int[array.length];
  minjumps[0] = 0; //base case

  for (int i = 1; i < array.length; i++) {
    minjumps[i] = -1;
    for (int j = 0; j < i; j++) {
      if (minjumps[j] != -1 && j + array[j] >= i) {
        if (minjumps[i] == -1 || minjumps[i] > 1 + minjumps[j]) {
          minjumps[i] = 1 + minjumps[j];
        }
      }
    }
  }

  return minjumps[array.length - 1];
}
