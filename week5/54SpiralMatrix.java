public class SpiralMatrixSolution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        
        if(matrix==null||matrix.length==0) return res;
        
        int rowBegin=0;
        int rowEnd=matrix.length-1;
        int colBegin=0;
        int colEnd=matrix[0].length-1;
        
        while(rowBegin<=rowEnd && colBegin<=colEnd){
            //Move right
            for(int i=colBegin;i<=colEnd;i++){ 
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++; //cut off the upper line
            
            //Move down
            for(int i=rowBegin;i<=rowEnd;i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--; //cut off the rightest line
            
            //Move left
            if(rowBegin<=rowEnd){ //case where the number of the rows is odd
                for(int i=colEnd;i>=colBegin;i--){
                    res.add(matrix[rowEnd][i]);
                }
                rowEnd--; //cut off the bottom line
            }
            
            //Move up
            if(colBegin<=colEnd){ //case where the number of the column is odd
                for(int i=rowEnd;i>=rowBegin;i--){
                    res.add(matrix[i][colBegin]);
                }
                colBegin++; //cut off the leftest line
            }
        }
        return res;
    }
}
