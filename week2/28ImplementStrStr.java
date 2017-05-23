public class ImplementStrStrSolution {
    public int strStr(String haystack, String needle) {
        if(haystack==null || needle==null) return -1;
        if(needle.length()==0) return 0; //wierd edge case
        
        for(int i=0;i<(haystack.length()-needle.length()+1);i++){
            if(haystack.charAt(i)==needle.charAt(0)){
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
