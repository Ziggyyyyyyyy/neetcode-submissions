class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        String str = "" + s.charAt(0);
        int low = 0;
        int high = 1;
        int cnt = 1;
        while(high<s.length()){
            if(!str.contains(String.valueOf(s.charAt(high)))){
                str+=s.charAt(high);
                high++;
            }else{
                str=str.substring(1);
            }
            cnt=Math.max(cnt,str.length());
        }
        return cnt;
    }
}