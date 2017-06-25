/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class InsertIntervalSolution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        
        int[] starts = new int[intervals.size()+1];
        int[] ends = new int[intervals.size()+1];
        boolean added = false;
        int counter = 0;
        for(Interval i : intervals) {
            if(!added && newInterval.start <= i.start) {
                starts[counter] = newInterval.start;
                ends[counter] = newInterval.end;
                counter++;
                added = true;
            }
            starts[counter] = i.start;
            ends[counter] = i.end;
            counter++;
        }
        
        if(!added) { //case where the inserted one should be the last pair
            starts[counter] = newInterval.start;
            ends[counter] = newInterval.end;
        }
        
        int startNumber = starts[0];
        int endNumber = ends[0];
        for(int i = 1; i< starts.length; i++) { //contacnating intervals and add them into a new list
            if(endNumber < starts[i]) {
                res.add(new Interval(startNumber, endNumber));
                startNumber = starts[i];
                endNumber = ends[i];
            }
            else {
                endNumber = Math.max(endNumber, ends[i]);
            }
        }
        
        res.add(new Interval(startNumber, endNumber)); //catch the last pair
        
        return res;
    }
}
