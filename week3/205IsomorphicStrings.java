public class IsomorphicStringsSolution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        
        char[] a = new char[256]; //256 is the total amount of extended ASCII characters
        char[] b = new char[256]; //We need two maps because the character mapping relation is one to one for both s->t and t->s
                                  //Think about edge case: ("abcb","cddd")
                                  //if we only use one map to map from s to t, the return would be true
    
        for(int i=0;i<s.length();i++){
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            
            if(a[ss-' ']!=Character.MIN_VALUE && a[ss-' ']!=tt) return false; // if we mapped the character from s before and its mapping
            else a[ss-' ']=tt;                                                //doesn't equal to the character from t
                                                                              // ' ' is the smallest character in ASCII
            
            if(b[tt-' ']!=Character.MIN_VALUE && b[tt-' ']!=ss) return false;
            else b[tt-' ']=ss;
        }
        return true;
    }
}
