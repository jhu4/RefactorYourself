public class CombinationSumSolution {
    //Recursive solution
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(candidates); //we can sort here or not, if not we need to remove left>=candidates[i] condition in the 14th line
        combinationSum(list,new ArrayList<>(),candidates,0,target);
        return list;
    }
    
    private void combinationSum(List<List<Integer>> list, List<Integer> array, int[] candidates, int start, int left){
        if(left<0) return;
        else if(left==0) list.add(new ArrayList<Integer>(array));
        else{
            for(int i=start;i<candidates.length && left>=candidates[i];i++){ //left>=candidates[i] -> pruning the recusion tree
                array.add(candidates[i]);
                combinationSum(list,array,candidates,i,left-candidates[i]);
                array.remove(array.size()-1);
            }
        }
    }
    
    //DP solution from https://discuss.leetcode.com/topic/8200/iterative-java-dp-solution, way slower than recursion
    public List<List<Integer>> combinationSum(int[] cands, int t) {
        Arrays.sort(cands); // sort candidates to try them in asc order
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= t; i++) { // run through all targets from 1 to t
            List<List<Integer>> newList = new ArrayList(); // combs for curr i
            // run through all candidates <= i
            for (int j = 0; j < cands.length && cands[j] <= i; j++) {
                // special case when curr target is equal to curr candidate
                if (i == cands[j]) newList.add(Arrays.asList(cands[j]));
                // if current candidate is less than the target use prev results
                else for (List<Integer> l : dp.get(i-cands[j]-1)) {
                    if (cands[j] <= l.get(0)) {
                        List cl = new ArrayList<>();
                        cl.add(cands[j]); cl.addAll(l);
                        newList.add(cl);
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(t-1);
    }
}
