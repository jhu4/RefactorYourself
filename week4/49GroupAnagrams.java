public class GroupAnagramsSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0) return new ArrayList<>();
        
        Map<String,List<String>> hash=new HashMap<>();
        for(String s:strs){
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String cString=new String(c);
            if(!hash.containsKey(cString)) hash.put(cString,new ArrayList<>());
            hash.get(cString).add(s);
        }
        
        return new ArrayList<>(hash.values());
    }
    
    
    //Another TLE solution, which is also my initial solution
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        if(strs==null||strs.length==0) return res;
        
        for(String s:strs){
            boolean isAdded=false;
            for(int i=0;i<res.size();i++){
                String compare=res.get(i).get(0);
                if(compare.length()==s.length()&&isAnagram(compare,s)){
                    res.get(i).add(s);
                    isAdded=true;
                }
            }
            if(!isAdded) res.add(new ArrayList<>(Arrays.asList(s)));
        }
        
        return res;
    }
    
    private boolean isAnagram(String a, String b){
        int[] hash=new int[26];
        for(int i=0;i<b.length();i++){
            hash[a.charAt(i)-'a']++;
            hash[b.charAt(i)-'a']--;
        }
        for(int n:hash){
            if(n!=0) return false;
        }
        return true;
    }
}
