class Solution {
    private static final int MOD = 1000000007;
    
    private int helper(String s, int n, int idx, int[] dp) {
        if (idx == n) return 1;
        if (s.charAt(idx) == '0') return 0;
        if (dp[idx] != -1) return dp[idx];
        
        long ways = 0;
        
        if (s.charAt(idx) == '*') {
            ways = (9L * helper(s, n, idx + 1, dp)) % MOD;
        } else {
            ways = helper(s, n, idx + 1, dp) % MOD;
        }
        
        if (idx + 1 < n) {
            if (s.charAt(idx) == '*' && s.charAt(idx + 1) == '*') {
                ways = (ways + 15L * helper(s, n, idx + 2, dp)) % MOD;
            } else if (s.charAt(idx) == '*') {
                if (s.charAt(idx + 1) >= '0' && s.charAt(idx + 1) <= '6') {
                    ways = (ways + 2L * helper(s, n, idx + 2, dp)) % MOD;
                } else {
                    ways = (ways + helper(s, n, idx + 2, dp)) % MOD;
                }
            } else if (s.charAt(idx + 1) == '*') {
                if (s.charAt(idx) == '1') {
                    ways = (ways + 9L * helper(s, n, idx + 2, dp)) % MOD;
                } else if (s.charAt(idx) == '2') {
                    ways = (ways + 6L * helper(s, n, idx + 2, dp)) % MOD;
                }
            } else {
                int num = Integer.parseInt(s.substring(idx, idx + 2));
                if (num >= 10 && num <= 26) {
                    ways = (ways + helper(s, n, idx + 2, dp)) % MOD;
                }
            }
        }
        
        return dp[idx] = (int) ways;
    }
    
    public int numDecodings(String s) {
        if (s.isEmpty()) return 0;
        int[] dp = new int[s.length()];
        java.util.Arrays.fill(dp, -1);
        return helper(s, s.length(), 0, dp);
    }
}