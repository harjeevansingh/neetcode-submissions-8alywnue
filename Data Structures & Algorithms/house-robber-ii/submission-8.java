class Solution {

    // Optimised - storing

    int[] maxLootFromHouses;
    int[] maxLootFromHouses2;

    public int dfs(int[] maxLoots, int[] nums, int i, int length){
        if(i >= length){
            return 0;
        }

        if(maxLoots[i] != 0){
            return maxLoots[i];
        }

        int next = dfs(maxLoots, nums, i+2, length);

        // int nextToNext = dfs(maxLoots, nums, i+3, length);

        int ans = Math.max(
            dfs(maxLoots, nums, i + 1, length),
            nums[i] + dfs(maxLoots, nums, i + 2, length)
        );
        maxLoots[i] = ans;

        return ans;
    }


    public int rob(int[] nums) {
        maxLootFromHouses = new int[nums.length];
        maxLootFromHouses2 = new int[nums.length];
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(
            // Math.max(
                dfs(maxLootFromHouses, nums, 0, nums.length-1), 
                // dfs(maxLootFromHouses, nums, 1, nums.length-1),
                // dfs(maxLootFromHouses, nums, 1, nums.length)
            // ),
            dfs(maxLootFromHouses2, nums, 1, nums.length)
        );
    }
}
