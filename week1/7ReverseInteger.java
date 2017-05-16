public class ReverseIntegerSolution {
    //My solution
    public int reverse1(int x) {
        int temp, result=0;
        while(x!=0){
            temp=x%10;
            x=(x-temp)/10;
            int newResult=result*10+temp;
            if((newResult-temp)/10!=result){
                return 0;
            }
            result=newResult;
        }
        return result;
      }
    
    //smarter solution to deal with overflow problem
    public int reverse2(int x) {
    long result =0;
    while(x != 0)
    {
        result = (result*10) + (x%10);
        if(result > Integer.MAX_VALUE) return 0;
        if(result < Integer.MIN_VALUE) return 0;
        x = x/10;
    }
      return (int)result;
    }
}
