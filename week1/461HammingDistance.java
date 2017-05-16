//My initial solution
public int hammingDistance1(int x, int y) {
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

//Better solution
public int hammingDistance2(int x, int y) {
    int xor=x^y;
    int result=0;
    while(xor!=0){
        result++;
        xor &= (xor-1); // this operation removes the right most 1 in binary form
    }
    return result;
}
