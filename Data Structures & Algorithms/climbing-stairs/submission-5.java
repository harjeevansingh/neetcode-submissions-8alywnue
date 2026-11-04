class Solution {
    int[] track;
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        track = new int[n+1];
        track[1] = 1;
        track[2] = 2;
        return helper(n);
    }

public int helper(int n) {
    if (track[n] != 0) {
        return track[n];
    }

    track[n] = helper(n - 1) + helper(n - 2);
    return track[n];
}
}
