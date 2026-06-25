class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int mid = (left+right)/2;
        int min = Integer.MAX_VALUE;

        while(left<=right){
            min = Math.min(min, nums[mid]);
            if(nums[left]<nums[right]){
                min = Math.min(min, nums[left]);
                break;
            }
            if(nums[left] > nums[mid]){
                right = mid-1;
            } else {
                left = mid + 1;
            }
            mid = (left+right)/2;
        }
        return min;
    }
}
