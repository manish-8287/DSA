class Solution {
    public int countLargestGroup(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int count=0;
        for(int i=1;i<=n;i++)
        {
            int sum = digitSum(i);
            map.put(sum , map.getOrDefault(sum,0)+1);
            max = Math.max(max , map.get(sum));
        }
        for(int x : map.values())
        {
            if(x==max) count++;
        }
        return count;
    }
    private int digitSum(int n)
    {
        int sum = 0;
        while(n>0)
        {
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
}