import java.lang.Math;
public class ValidSudokuSolution {
    //My initial solution
    public boolean isValidSudoku(char[][] board){
        boolean[][] x=new boolean[board.length][board.length];
        boolean[][] y=new boolean[board.length][board.length];
        boolean[][] smallerSquare=new boolean[board.length/3*board.length/3][board.length];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]!='.'){
                    int num=board[i][j]-'0'-1;
                    //check x direction
                    if(x[i][num]) return false;
                    else x[i][num]=true;
                    //check y direction 
                    if(y[j][num]) return false;
                    else y[j][num]=true;
                    //check smaller squares
                    if(smallerSquare[i/3+j/3*3][num]) return false; //  j/3*3!=j because j/3 is a int operation and it will floor the result
                    else smallerSquare[i/3+j/3*3][num]=true; // i/3 represents the index of the smaller square in x direction
                                                             // j/3 represents the index of the smaller square in y direction
                                                             // (j/3)*3 adds the offset to the converted index
                }
            }
        }
        return true;
    }
}
