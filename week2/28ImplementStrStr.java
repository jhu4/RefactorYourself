public class ImplementStrStrSolution {
    
    //holly crap! I fucking could use substring instead
    public int strStr2(String haystack, String needle) {
        if(haystack==null || needle==null) return -1;
        if(needle.length()==0) return 0; //wierd edge case
        
        for(int i=0;i<(haystack.length()-needle.length()+1);i++){
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }
    
    
    //My first stupid answer
    public int strStr1(String haystack, String needle) {
        if(haystack==null || needle==null) return -1;
        if(needle.length()==0) return 0; //wierd edge case
        
        for(int i=0;i<(haystack.length()-needle.length()+1);i++){
            if(haystack.charAt(i)==needle.charAt(0)){   //DO NOT USE THIS STUPID FOR LOOP METHOD TO COMPARE STRINGS AGAIN
                int j=1;
                while(j<needle.length() && haystack.charAt(i+j)==needle.charAt(j)){
                    j++;
                }
                if(j==needle.length()) return i;
            }
        }
        return -1;
    }
 
}
