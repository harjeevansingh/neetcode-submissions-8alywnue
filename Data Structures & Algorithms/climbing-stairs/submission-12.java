class Solution {
    
    public int climbStairs(int n) {
        int one = 1;
        int two = 1;

        for(int i=2;i<=n;i++){
            int temp = one;
            one = two;
            two = two+temp;
        }

        return two;
    }
}


// 1 - 1
// 2 - 2
// 3
// 4