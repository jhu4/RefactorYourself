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
}
