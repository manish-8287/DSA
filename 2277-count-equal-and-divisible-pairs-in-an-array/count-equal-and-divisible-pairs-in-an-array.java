class Solution {
    public int countPairs(int[] nums, int k) {
        int count=0;
        Map<Integer,List<Integer>> m = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            m.computeIfAbsent(nums[i] , x -> new ArrayList<>()).add(i);
        }
        for(List<Integer> index : m.values())
        {
            for(int i=0;i<index.size()-1;i++)
            {
                for(int j=i+1;j<index.size();j++)
                {
                    if(((long)index.get(i)*index.get(j)) %k == 0) count++;
                }
            }
        }
        return count;
    }
}