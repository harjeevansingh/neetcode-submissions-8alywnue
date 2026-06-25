class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left<=right){
            System.out.println("left - " + left);
            System.out.println("right - " + right);
            int mid = (left+right)/2;
            System.out.println("mid - " + mid);
            System.out.println("nums[mid] - " + nums[mid]);

            if(nums[mid]==target){
                return mid;
            }
            if(nums[left]<nums[right]){
                if(target<nums[mid]){
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            } else{
                if(nums[left]<=nums[mid]){
                    if(target >= nums[left] && target < nums[mid]){
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else{
                    if(target < nums[mid] || target > nums[right]){
                        right = mid -1;
                    } else{
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
