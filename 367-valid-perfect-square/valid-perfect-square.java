class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 1;
        long high = num;
        boolean result = false;
        while(low<=high)
        {
            long mid = low + (high-low) /2;
            long square = mid*mid;
            if(square == num) 
            {
                result = true;
                break;
            }
            else if(square< num)
            {
                low = (int)mid+1;
            }
            else{
                high = (int)mid-1;
            }
        }
        return result;
    }
}