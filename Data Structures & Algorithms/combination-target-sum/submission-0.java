class Solution {
    public void combinationHelper(int index, int target, int[] nums, List<Integer> currentList, List<List<Integer>> answer){
        if(index == nums.length){
            if(target == 0){
                answer.add(new ArrayList<>(currentList));
            }
            return;
        }

        if(nums[index] <= target){
            currentList.add(nums[index]);
            combinationHelper(index , target - nums[index], nums, currentList, answer);
            currentList.remove(currentList.size() - 1);
        }
        combinationHelper(index + 1, target, nums, currentList, answer);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        combinationHelper(0 , target, nums, new ArrayList<Integer>(), answer);
        return answer;
    }
}
