class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,candidates,target,ans,ds);
        return ans;
    }
    private void findCombinations(int idx,int[] candidates,int target,List<List<Integer>> ans,List<Integer> ds){
            if(target==0){
                ans.add(new ArrayList<>(ds));
                return;
            }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            ds.add(candidates[i]);
            findCombinations(i+1,candidates,target-candidates[i],ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}
