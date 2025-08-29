class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int m= nums1.length;
        int n = nums2.length;
        int[] result = new int[Math.min(m,n)];
        int idx = 0;
        Map<Integer ,Boolean> m1 = new HashMap<>();
        for(int i=0; i<m;i++)
        {
            m1.put(nums1[i] , true);   
        }
        for(int j=0;j<n;j++)
        {
            if(m1.containsKey(nums2[j]))
            {
                result[idx++] = nums2[j];
                m1.remove(nums2[j]);
            }
        }
        return Arrays.copyOf(result,idx);
    }
}