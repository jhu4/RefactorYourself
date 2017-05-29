import java.lang.Math;
public class DivideTwoIntegersSolution {
    //Refer other's solution. Was stuck on this question becasue TLE
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        if(divisor==1) return dividend;
        if(divisor==-1) return -dividend;
        
    	long result = divideLong(dividend, divisor);
    	return (int)result;
    }
    
    // It's easy to handle edge cases when
    // operate with long numbers rather than int
    public long divideLong(long dividend, long divisor) {
    	
    	// Remember the sign
    	boolean negative = dividend < 0 != divisor < 0;
    	
    	// Make dividend and divisor unsign
    	if (dividend < 0) dividend = -dividend;
    	if (divisor < 0) divisor = -divisor;
    	
    	// Return if nothing to divide
    	if (dividend < divisor) return 0;
    	
    	// Sum divisor 2, 4, 8, 16, 32 .... times
        long sum = divisor;
        long divide = 1;
        while ((sum+sum) <= dividend) {
        	sum += sum;
        	divide += divide;
        }
        
        // Make a recursive call for (devided-sum) and add it to the result
        return negative ? -(divide + divideLong((dividend-sum), divisor)) :
        	(divide + divideLong((dividend-sum), divisor));
    }
} 
