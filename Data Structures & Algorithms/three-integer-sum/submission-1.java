class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        int length = nums.length;

        List<List<Integer>> result = new ArrayList();

        while(i<=length - 3){

            if(i>0 && nums[i]==nums[i-1]){
                i++;
                continue;
            }

            int start = i + 1;
            int end = length - 1;
            
            while(start<end){
                int sum = nums[i] + nums[start] + nums[end];
                // if(nums[start] == nums[start-1]){
                //     start++;
                //     continue;
                // }
                // if(end < length-1 && nums[end] == nums[end+1]){
                //     end--;
                //     continue;
                // }
                if(sum==0){
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    while(nums[start] == nums[start-1] && start<end){
                        start++;
                    }
                    continue;
                } else if(sum<0){
                    start++;
                    continue;
                } else{
                    end--;
                    continue;
                }
            }

            i++;
        }

        return result;
    }
}
