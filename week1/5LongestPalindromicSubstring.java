public class LongestPalindromicSubstringSolution {
    //DP solution O(n^2) time complexity
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0) return null;
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        int[] result={0,0};
        
        dp[0][0]=true; //cover the first one
        for(int i=1;i<len;i++){
            dp[i][i]=true; //single character is palindromic
            if(s.charAt(i-1)==s.charAt(i)){
                dp[i-1][i]=true; //check if there palindromic substring of length of 2
                result[0]=i-1;
                result[1]=i;
            }
        }
        
        for(int size=3;size<=len;size++){ //the length of substring can varies from 3 to the length of the input string
            for(int start=0;start<=len-size;start++){ //calculate the range of the start index
                int end=start+size-1; //calculate the end index
                if(dp[start+1][end-1] && s.charAt(start)==s.charAt(end)){
                    dp[start][end]=true;
                    if(end-start>result[1]-result[0]){ //update
                        result[0]=start;
                        result[1]=end;
                    }
                } 
            } 
        }
        return s.substring(result[0],result[1]+1);
    }
    
    //TODO Manacher's algorithm 
}
