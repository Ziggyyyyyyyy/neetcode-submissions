class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        findCombinations(0,nums,target,ans,ds);
        return ans;
    }
    private void findCombinations(int idx,int[] nums,int target,List<List<Integer>> ans,List<Integer> ds){
        int n=nums.length;
        if(idx==n){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(nums[idx]<=target){
            ds.add(nums[idx]);
            findCombinations(idx,nums,target-nums[idx],ans,ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(idx+1,nums,target,ans,ds);
    }
}
