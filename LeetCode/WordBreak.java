
// 2d DP, time: O(n^2); space: O(n), n is the length of the string
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s==null || s.length()==0)   return true;
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=1; i<=s.length(); i++){
            for (int j=i-1; j>=0; j--){
                if (dict.contains(s.substring(j,i)) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}