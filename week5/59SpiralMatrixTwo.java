public class SpiralMatrixTwoSolution {
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        if(n<=0) return res;
        
        int upbound=0,leftbound=0,rightbound=n-1,downbound=n-1,num=1;
        
        while(upbound<=downbound){
            for(int i=leftbound;i<=rightbound;i++){
                res[upbound][i]=num++;
            }
            upbound++;
            
            for(int j=upbound;j<=downbound;j++){
                res[j][rightbound]=num++;
            }
            rightbound--;
            
            for(int x=rightbound;x>=leftbound;x--){
                res[downbound][x]=num++;
            }
            downbound--;
            
            for(int y=downbound;y>=upbound;y--){
                res[y][leftbound]=num++;
            }
            leftbound++;
        }
        
        return res;
    }
}
