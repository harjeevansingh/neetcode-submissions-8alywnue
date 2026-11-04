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
        // if(n==0){
        //     return 1;
        // }
        // if(n==2){
        //     return 2;
        // }
        if(n<0){
            return 0;
        }
        int one = track[n-1];
        int two = track[n-2];
        track[n] =  (one != 0 ? one : helper(n-1)) + (two != 0 ? two : helper(n-2));
        return track[n];
    }
}
