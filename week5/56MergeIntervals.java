/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    //it turn out merge1 TLE becasue I used list.remove which is O(n) operation
    //Same idea, instead of manipulating in the original list we add the qualified one to the new list
    public List<Interval> merge2(List<Interval> intervals) {
        List<Interval> res=new ArrayList<>();
        if(intervals==null||intervals.size()==0) return res;
        
        Collections.sort(intervals,new Comparator<Interval>(){ //sorting the intervals
            @Override
            public int compare(Interval a,Interval b){
                if(a.start>b.start) return 1;
                else if(a.start==b.start) return 0;
                else return -1;
            }
        });
        
        int count=0;
        res.add(intervals.get(0));
        
        for(int i=1;i<intervals.size();i++){
            Interval pre=res.get(count);
            Interval cur=intervals.get(i);
            if(cur.start<=pre.end){ //case where we need to merge
                if(cur.end>pre.end) //merge only if intervals are partially overlapped, ignore if one interval
                    pre.end=cur.end;//is contained within another
            }
            else{
                res.add(cur);//if the current interval are totally seperate, add it to the result
                count++;
            }
            
        }
        
        return res;
    }
    
    //My initial TLE solution
    public List<Interval> merge1(List<Interval> intervals) {
        if(intervals==null||intervals.size()==0) return new ArrayList<>();
        
        Collections.sort(intervals,new Comparator<Interval>(){ //sort the list
            @Override
            public int compare(Interval a,Interval b){
                if(a.start>b.start) return 1;
                else if(a.start==b.start) return 0;
                else return -1;
            }
        });
        
        int cur=1,last=intervals.size();
        
        while(cur<last){
            Interval preInterval=intervals.get(cur-1);
            Interval curInterval=intervals.get(cur);
            if(preInterval.end>=curInterval.start){ //case where we need to merge
                if(preInterval.end<curInterval.end) //we only need to merge if two intervals is partially overlapped
                    preInterval.end=curInterval.end;
                intervals.remove(cur);
                last--;
            }
            else cur++;
        }
        
        return intervals;
    }
}
