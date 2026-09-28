class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numComplement = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            if(numComplement.containsKey(target-nums[i])){
                return new int[]{numComplement.get(target-nums[i]), i};
            } else{
                numComplement.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
