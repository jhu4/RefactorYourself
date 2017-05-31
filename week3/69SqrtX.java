public class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        if(x==1) return 1;
        
        int lo=1,hi=x/2,mid=(int)(lo/2.0+hi/2.0); //lo starts at 1 to avoid divide by zero exception
        
        while(lo<=hi){
            if(x/mid==mid||(x/(mid+1)<(mid+1)&&x/mid>mid)) return mid; //using x/mid==mid instead of x==mid*mid to avoid overflow
            else if(x/mid<mid) hi=mid-1;
            else lo=mid+1;
            mid=(int)(lo/2.0+hi/2.0); //using double division to avoid lossing accuracy and avoid overflow
        }
        
        return lo;
    }
}
