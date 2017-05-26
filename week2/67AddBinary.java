public class Solution {
    public String addBinary(String a, String b) {
        if(a.length()<b.length()){ //swapp a b is a is shorter
            String temp=a;
            a=b;
            b=temp;
        }
        
        StringBuilder aa=new StringBuilder(a);
        int alen=a.length(),blen=b.length();
        char carry='0';
        for(int i=0;i<alen;i++){
            char achar=a.charAt(alen-1-i); //from back to front
            char bchar=i<blen?b.charAt(blen-1-i):'0';
            
            //manipulate the digits in string buidler
            switch(achar+bchar+carry){
                case ('1'+'1'+'1'):
                    aa.setCharAt(alen-1-i,'1');
                    //carry is still one, we don't need to set it
                    break;
                case ('1'+'1'+'0'):
                    aa.setCharAt(alen-1-i,'0');
                    carry='1';
                    break;
                case ('1'+'0'+'0'):
                    aa.setCharAt(alen-1-i,'1');
                    carry='0';
                    break;
                case ('0'+'0'+'0'):
                    //nothing happened
                    break;
            }
        }
        if(carry=='1') return "1"+aa.toString();
        else return aa.toString();
    }
    
    //Another solution that is pretty concise
    public String addBinary2(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
