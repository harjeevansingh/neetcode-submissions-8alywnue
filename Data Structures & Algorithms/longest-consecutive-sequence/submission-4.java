class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int left = 0;
        int right = 1;
        int currentLength = 1;
        int longestLength = 1;

        while (right < nums.length) {
            if (nums[right] == nums[right - 1]) {
                right++;
                continue;
            }

            if (nums[right] - nums[right - 1] == 1) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            longestLength = Math.max(longestLength, currentLength);
            right++;
        }

        return longestLength;
    }
}