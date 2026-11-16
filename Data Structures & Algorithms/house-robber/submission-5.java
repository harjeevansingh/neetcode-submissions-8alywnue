class Solution {

    // Optimised - storing

    int[] maxLootFromHouses;

    public int dfs(int[] nums, int i){
        if(i >= nums.length){
            return 0;
        }

        if(maxLootFromHouses[i] != 0){
            return maxLootFromHouses[i];
        }

        int next = dfs(nums, i+2);

        int nextToNext = dfs(nums, i+3);

        int ans = nums[i] + Math.max(next, nextToNext);

        maxLootFromHouses[i] = ans;

        return ans;
    }


    public int rob(int[] nums) {
        maxLootFromHouses = new int[nums.length];
        return Math.max(dfs(nums, 0), dfs(nums, 1));
    }
}
