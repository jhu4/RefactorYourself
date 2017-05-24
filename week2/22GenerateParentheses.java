public class Solution {
    //My recursion method
    public List<String> generateParenthesis(int n) {
        if(n==0) return new ArrayList<String>();
        
        return generateP(n);
        
    }
    private List<String> generateP(int n){
        List<String> res=new ArrayList<String>();
        if(n==0){
            res.add("");
            return res;
        }
        if(n==1){  //Doesn't really need this if statement but it is faster if we do this
            res.add("()");
            return res;
        }
        
        for(int i=0;i<n;i++){
            List<String> inner=generateP(i);
            List<String> outer=generateP(n-1-i);
            for(int x=0;x<inner.size();x++){
                for(int y=0;y<outer.size();y++){
                    res.add("("+inner.get(x)+")"+outer.get(y));
                }
            }
        }
        return res;
    }
}
