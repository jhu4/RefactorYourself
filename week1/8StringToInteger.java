public class StringToIntegerSolution {
    //My solution, wierdly  slowwwwwww QAQ
    public int myAtoi1(String str) {
        int i=0,sign=1;
        long result=0;
        
        while(i<str.length() && str.charAt(i)==' '){
            i++;
        }
        
        if(i<str.length() && (str.charAt(i)=='+' || str.charAt(i)=='-')){
            sign=str.charAt(i)=='+'?1:-1;
            i++;
        }
        
        while(i<str.length()){
            int num=str.charAt(i)-'0';
            if(num<0 || num>9) return (int)result*sign;
            
            result=result*10+num;
            if(result*sign<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(result*sign>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            
            i++;
        }
        return (int)result*sign;
    }
}
