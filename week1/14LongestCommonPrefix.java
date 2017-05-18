public class LongestCommonPrefixSolution {
    //Orz too much corner cases! My stupid solution
    public String longestCommonPrefix1(String[] strs) {
        if(strs==null || strs.length==0) return "";
        int minlen=Integer.MAX_VALUE,len=strs.length;
        for(int i=0;i<len;i++){
            minlen=minlen<strs[i].length()?minlen:strs[i].length();
        }
        if(minlen==0) return "";
        
        for(int i=0;i<minlen;i++){
            char cur=strs[0].charAt(i);
            for(int j=1;j<len;j++){
                if(strs[j].charAt(i)!=cur) return strs[0].substring(0,i);
            }
        }
        return strs[0].substring(0,minlen);
    }
    
    //A solution well used of indexOf(String s) and way neater, but not faster
    public String longestCommonPrefix2(String[] strs) {
      if (strs==null || strs.length == 0) return "";
      String pre = strs[0];
      for (int i = 1; i < strs.length; i++)
          while(strs[i].indexOf(pre) != 0)
              pre = pre.substring(0,pre.length()-1);
      return pre;
    }
}
