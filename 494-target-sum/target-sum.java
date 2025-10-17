class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int n : nums)
        {
            sum += n;
        }
        if((sum+target) % 2 != 0 || (sum+target) < 0 || sum < target) return 0;
        int diff = (sum+target) / 2;
        int[][] dp = new int[nums.length+1][diff+1];
        dp[0][0] = 1;
        for(int i=1;i<nums.length+1;i++)
        {
            for(int j=0;j<diff+1;j++)
            {
                if(nums[i-1] <= j)
                {
                    dp[i][j] = dp[i-1][j- nums[i-1]] + dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][diff];
    }
}