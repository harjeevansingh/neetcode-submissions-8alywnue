class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndexMap = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            int numCompliment = target - nums[i];
            if(numToIndexMap.containsKey(numCompliment)){
                return new int[]{numToIndexMap.get(numCompliment), i};
            } else{
                numToIndexMap.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
