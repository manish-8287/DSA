class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > n / 2) {
                result = nums[i];
                break;  
            }
        }
        return result;
    }
}
