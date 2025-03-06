class Solution {
    int func(String s , int start , int end, int[][] dp)
    {
        if(start>end) return 0;
        if(start==end) return 1;
        if(dp[start][end]!=-1) return dp[start][end];
        if(s.charAt(start)==s.charAt(end)) return dp[start][end]= 2+func(s,start+1,end-1,dp);
        dp[start][end]= Math.max(func(s,start+1,end,dp) , func(s,start,end-1,dp));
        return dp[start][end];

    }
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] rows : dp)
        {
            Arrays.fill(rows,-1);
        }
        return func(s,0,s.length()-1,dp);
    }
}