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
    //My initial TLE solution
    public List<Interval> merge(List<Interval> intervals) {
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
