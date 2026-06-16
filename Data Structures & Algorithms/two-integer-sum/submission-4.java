class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int diff = target - num;
            if(numMap.containsKey(diff)){
                return new int[]{numMap.get(diff), i};
            } 
            numMap.put(num, i);
        }

        return new int[]{};
    }
}
