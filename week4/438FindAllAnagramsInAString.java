public class FindAllAnagramsInAStringSolution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        if(s.length()<p.length()) return res;
        
        int[] hash=new int[256];
        int count=p.length(),left=0,right=0;
        for(char c:p.toCharArray()){
            hash[c]++;
        }
        
        while(right<s.length()){
            if(hash[s.charAt(right)]>0) count--; //if the char is in the hash, decrease the count
            hash[s.charAt(right)]--; //move the right ptr and decrease the # in hashmap
            right++;
            
            if(count==0) res.add(left); //if count is 0, if means we found the anagram
            
            if(right-left==p.length()){ //after the window is as big as the length of String p, left ptr can start to move
                if(hash[s.charAt(left)]>=0) count++; //if count>=0, it means the char is in p(because the char not in p should be negative)
                hash[s.charAt(left)]++; //add the count, move left ptr, add the storage in the hashmap
                left++;
            }
        }
        return res;
    }
}
