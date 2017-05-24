import java.lang.Math;
public class LengthOfLastWordSolution {
    public int lengthOfLastWord1(String s) {
        int cur=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' ' && cur>0){
                return cur;
            }
            else if(s.charAt(i)!=' '){
                cur++;
            }
        }
        return cur;
    }
    
    //very smart practical answer
    public int lengthOfLastWord2(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;
    }
}
