public class ZigZagConversionSolution {
    //My solution, I thought it would be slow but it magically beat 78% of java submissions (shrug.gif)
    public String convert1(String s, int numRows) {
        if (numRows==1) return s;
        List<StringBuilder> sb=new ArrayList<StringBuilder>();
        for(int i=0;i<numRows;i++){
            sb.add(new StringBuilder());
        }
        int dir=1,count=0;
        for(int i=0;i<s.length();i++){
            sb.get(count).append(s.charAt(i));
            count+=dir;
            if(count==0) dir=1;
            if(count==numRows-1) dir=-1;
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<numRows;i++){
            result.append(sb.get(i).toString());
        }
        return result.toString();
    }
}
