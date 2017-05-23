public class ImplementStrStrSolution {
    
    //holly crap! I fucking could use substring instead
    public int strStr2(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i,i+l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
    
    public int strStr1(String haystack, String needle) {
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
