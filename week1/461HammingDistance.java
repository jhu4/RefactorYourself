//easy
public int hammingDistance(int x, int y) {
    int xor=x^y;
    int result=0;
    while(xor!=0){
        if((xor&1)==1){
            result++;
        }
        xor=xor>>1;
    }
    return result;
}
