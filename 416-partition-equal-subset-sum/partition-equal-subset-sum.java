class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
        }
        Boolean[][] dp = new Boolean[nums.length+1][sum+1];
        if(sum % 2 == 0)
        {
            return func(nums , sum/2 , 0 , dp);
        }
        else
        {
            return false;
        }
    }
    public static boolean func(int[] arr , int sum , int idx , Boolean[][] dp )
    {
        if(sum == 0) return true;
        if(idx == arr.length) return false;
        if(dp[idx][sum] != null) return dp[idx][sum];

        if(arr[idx] <= sum)
        {
            return dp[idx][sum] = func(arr , sum - arr[idx] , idx+1 , dp) || func(arr , sum , idx+1,dp);
        }
        else
        {
            return dp[idx][sum] = func(arr , sum , idx+1 , dp);
        }
    }
}