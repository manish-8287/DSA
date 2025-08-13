class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxCount = 0;
        int maxEle = -1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] % 2 == 0)
            {
                if(map.containsKey(nums[i])){
                    map.put(nums[i] , map.get(nums[i]) + 1);
                }
                else
                {
                    map.put(nums[i] , 1);
                }
            if(maxCount < map.get(nums[i]))
            {
                maxCount = map.get(nums[i]);
                maxEle = nums[i];
            }
            else if(maxCount == map.get(nums[i]) && maxEle > nums[i])
            {
                maxEle = nums[i];
            }
        }
    }
        return maxEle;
    }
}