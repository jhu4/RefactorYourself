public class ClimbingStairsSolution {
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        
        //climbStairs(n)=climbStairs(n-1)+climbStairs(n-2)
        //we can climb 1 or 2 steps...it means that we can climb 1 stair after n-1 stairs or 2 stairs after n-2 stairs
        //so there are climbStairs(n-1) ways + climbStairs(n-2) ways
        int first=1,second=2,res=0;
        
        for(int i=3;i<=n;i++){
            res=first+second;
            first=second;
            second=res;
        }
        
        return res;
    }
}
