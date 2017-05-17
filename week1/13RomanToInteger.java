import java.util.*;
public class RomanToIntegertSolution {
    //My initial thought of using hashmap
    public int romanToInt1(String s) {
        Hashtable<Character,Integer> map=new Hashtable<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result=0,last=0;
        for(int i=s.length()-1;i>=0;i--){
            int cur=map.get(s.charAt(i));
            result=cur>=last?result+cur:result-cur;
            last=cur;
        }
        return result;
    }
    
    //Tried switch-case and it was wayyyyyyy faster
    public int romanToInt2(String s) {
        int result=0,last=0,cur=0;
        for(int i=s.length()-1;i>=0;i--){
            switch(s.charAt(i)){
                case 'I':
                    cur=1;
                    break;
                case 'V':
                    cur=5;
                    break;
                case 'X':
                    cur=10;
                    break;
                case 'L':
                    cur=50;
                    break;
                case 'C':
                    cur=100;
                    break;
                case 'D':
                    cur=500;
                    break;
                case 'M':
                    cur=1000;
                    break;
            }
            result=cur>=last?result+cur:result-cur;
            last=cur;
        }
        return result;
    }
}
