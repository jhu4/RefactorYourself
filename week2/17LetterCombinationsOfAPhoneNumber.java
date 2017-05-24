public class LetterCombinationsOfAPhoneNumberSolution {
    //My solution using recursion
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<String>();
        String[] phone = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits==null || digits.length()==0)  return res;
        
        int firstdigit=digits.charAt(0)-'0';
        String s=phone[firstdigit];
        
        for(int i=0;i<s.length();i++){
            if(digits.length()==1){
                res.add(String.valueOf(s.charAt(i)));
            }
            else{
                List<String> recur=letterCombinations(digits.substring(1));
                for(int j=0;j<recur.size();j++){
                    res.add(s.charAt(i)+recur.get(j));
                }
            }
        }
        return res;
    }
    
    //Solution using Queue from https://discuss.leetcode.com/topic/8465/my-java-solution-with-fifo-queue
    public List<String> letterCombinations1(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits==null || digits.length()==0) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
}
