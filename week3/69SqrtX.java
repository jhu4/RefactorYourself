public class SqrtXSolution {
    //Newton method
    public int mySqrt2(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
    
    //My initial solution: binary search
    public int mySqrt1(int x) {
        if(x==0) return 0;
        if(x==1) return 1;
        
        int lo=1,hi=x/2,mid=(lo+hi)/2;
        
        while(lo<=hi){
            if(x/mid==mid||(x/(mid+1)<(mid+1)&&x/mid>mid)) return mid; //using x/mid==mid instead of x==mid*mid to avoid overflow
            else if(x/mid<mid) hi=mid-1;
            else lo=mid+1;
            mid=(lo+hi)/2; //we don't need to consider the overflow case because lo+hi is at max 2*hi where hi is at max x/2
        }
        return lo;
    }
}
