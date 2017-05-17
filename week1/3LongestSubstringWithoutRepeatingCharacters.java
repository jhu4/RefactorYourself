import java.lang.Math;
import java.util.*;
public class LongestSubstringWithoutRepeatingCharactersSolution {
    //My solution
    public int lengthOfLongestSubstring1(String s) {
        int max=0,cur=0,start=0;
        Hashtable<Character,Integer> map = new Hashtable<Character, Integer>();
        for(int index=0; index<s.length();index++){
            char c=s.charAt(index);
            if(map.containsKey(c) && start<=map.get(c)){
                max=Math.max(cur,max);
                start=map.get(c)+1;
                cur=index-map.get(c);
            }
            else{
                cur++;
            }
            
            map.put(c,index);
        }
        return Math.max(cur,max);
    } 
    
    
}
