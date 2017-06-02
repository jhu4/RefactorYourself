public class CombinationSumTwoSolution {
    //Recursive solution
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list=new ArrayList<>();
        combinationSumTwo(list,new ArrayList<>(),target,0,candidates);
        return list;
    }
    
    /**
     *  Thinks about special test case ([2,2,2,2,2,2,2], 4)
     */
    private void combinationSumTwo(List<List<Integer>> list, List<Integer> cur, int left, int start, int[] candidates){
        if(left==0) list.add(new ArrayList<>(cur)); //becareful to make a new instance of ArrayList<Integer>
        else if(left<0 || start>candidates.length) return;
        else{
            for(int i=start;i<candidates.length && candidates[i]<=left;i++){ //pruning
                if(i==start||candidates[i]!=candidates[i-1]){ //can not put duplicate elements on the same index in the list
                    cur.add(candidates[i]);
                    combinationSumTwo(list,cur,left-candidates[i],i+1,candidates);
                    cur.remove(cur.size()-1);
                }
            }
        }
    }
}
