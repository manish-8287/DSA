class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=1;i<=n;i++)
        {
            int sum = nums[i-1];
            if(n%i == 0)
            {
                ans += sum*sum;
            }
        }
        return ans;
    }
}