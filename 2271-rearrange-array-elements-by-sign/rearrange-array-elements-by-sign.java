class Solution {
    public int[] rearrangeArray(int[] nums) {
        int i=0,j=1;
        int n=nums.length;
        int arr[]=new int[n];
        for(int k=0;k<n;k++){
            if(nums[k]>0){
                arr[i]=nums[k];
                i=i+2;
            }
            else{
                arr[j]=nums[k];
                j=j+2;
            }
        }
        return arr;
    }
}