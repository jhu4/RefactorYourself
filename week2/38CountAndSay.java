public class Solution {
    //Itinerary solution
    public String countAndSay(int n) {
        StringBuilder sb=new StringBuilder("1");
        for(int i=1;i<n;i++){ //loops n times
            int count=0;
            StringBuilder newstring=new StringBuilder();
            for(int j=1;j<=sb.length();j++){ //go through the current string
                count++;
                if(j==sb.length() || sb.charAt(j)!=sb.charAt(j-1)){
                    newstring.append(count);
                    newstring.append(sb.charAt(j-1));
                    count=0;
                }
            }
            sb=newstring;
        }
        return sb.toString();
    }

    //Recursive solution...Frankly this is faster than itinerary solution
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }else{
            String prev = countAndSay(n-1); 
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for(int j = 1; j <= prev.length(); j++){
                if(j==prev.length() || prev.charAt(j) != prev.charAt(j-1)){
                    sb.append(j-i); 
                    sb.append(prev.charAt(i));
                    i = j;
                }
            }
            return sb.toString();
        }
    }
}
