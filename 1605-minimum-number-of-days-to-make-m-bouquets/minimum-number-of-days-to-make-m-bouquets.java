class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k > bloomDay.length) return -1;
        int low = 1;
        int high =0;
        int ans = -1;
        for(int i=0;i<bloomDay.length;i++)
        {
            high = Math.max(high, bloomDay[i]);
        }
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            int x=0;
            int z=0;
            for(int n : bloomDay)
            {
                if(n <=mid)
                {
                    x++;
                    if(x==k)
                    {
                        z++;
                        x=0;
                    }
                }
                else
                {
                    x=0;
                }
            }
            if(z >= m)
            {
                ans = mid;
                high=mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return ans;
    }
}