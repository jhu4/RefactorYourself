public class IntegerToRomanSolution {
    //My solution, runs very slow
    public String intToRoman1(int num) {
        int[] romansInt={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romansString={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<romansInt.length;i++){
            while(num>=romansInt[i]){
                num-=romansInt[i];
                sb.append(romansString[i]);
            }
        }
        return sb.toString();
    }
}
