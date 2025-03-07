class Solution {
    int func(String s , int start , int end,int[][] dp)
    {
        if(start>end) return 0;
        if(dp[start][end]!=-1) return dp[start][end];
        if(s.charAt(start)==s.charAt(end))
        {
           return dp[start][end] = func(s , start+1 , end-1,dp);
        }
        else
        {
            dp[start][end]= Math.min(1+func(s , start+1 , end,dp) , 1+func(s, start,end-1,dp));
        }
        return dp[start][end];
    }
    public int minInsertions(String s) {
        int[][] dp  = new int[s.length()+1][s.length()+1];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        return func(s,0,s.length()-1,dp);
    }
}