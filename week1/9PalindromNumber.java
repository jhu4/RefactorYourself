public class PalindromeNumberSolution {
    //My solution
    public boolean isPalindrome1(int x) {
        if(x<0) return false;
        int xx=x;
        int y=0;
        while(x!=0){
            y=y*10+x%10;
            x/=10;
        }
        return y==xx;
    }
    
    //Another way(other's solution) to do it is to only compare half of the digits
    public boolean isPalindrome2(int x) {
      if (x<0 || (x!=0 && x%10==0)) return false;
      int rev = 0;
      while (x>rev){
        rev = rev*10 + x%10;
        x = x/10;
      }
      return (x==rev || x==rev/10);
    }
}
