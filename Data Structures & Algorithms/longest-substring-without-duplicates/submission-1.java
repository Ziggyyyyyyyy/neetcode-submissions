class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int low=0,high=0;
        int cnt=0;
        HashSet<Character> set=new HashSet<>();
        while(high<s.length()){
            if(!set.contains(s.charAt(high))){
                set.add(s.charAt(high));
                cnt=Math.max(cnt,high-low+1);
                high++;
            }else{
                set.remove(s.charAt(low));
                low++;
            }
        }
        return cnt;
    }
}