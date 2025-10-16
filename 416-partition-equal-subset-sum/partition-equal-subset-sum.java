class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
        }
        if(sum % 2 != 0 ) return false;
        int target = sum/2;
        boolean[][] dp = new boolean[nums.length+1][target+1];
        for(int i=0;i<nums.length+1;i++)
        {
            dp[i][0] = true;
        }
        for(int i=1;i<nums.length+1;i++)
        {
            for(int j=1 ; j<target+1 ; j++)
            {
                if(nums[i-1] <= j)
                {
                    dp[i][j] = dp[i-1][j - nums[i-1]] || dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
    // public static boolean func(int[] arr , int sum , int idx , Boolean[][] dp )
    // {
    //     if(sum == 0) return true;
    //     if(idx == arr.length) return false;
    //     if(dp[idx][sum] != null) return dp[idx][sum];

    //     if(arr[idx] <= sum)
    //     {
    //         return dp[idx][sum] = func(arr , sum - arr[idx] , idx+1 , dp) || func(arr , sum , idx+1,dp);
    //     }
    //     else
    //     {
    //         return dp[idx][sum] = func(arr , sum , idx+1 , dp);
    //     }
    // }
}