class Solution {
    public int[] twoSum(int[] nums, int target) {
        // two pointer solution
        int[][] numsWithIndex = new int[nums.length][2];
        
        for(int i=0;i<nums.length;i++){
            numsWithIndex[i][0] = nums[i];
            numsWithIndex[i][1] = i;
        }

        Arrays.sort(numsWithIndex, Comparator.comparingInt(a -> a[0]));

        int i=0, j=nums.length-1;

        while(i<j){
            int sum = numsWithIndex[i][0] + numsWithIndex[j][0];
            if(sum == target){
                return new int[]{
                    Math.min(numsWithIndex[i][1], numsWithIndex[j][1]),
                    Math.max(numsWithIndex[i][1], numsWithIndex[j][1])
                };
            } else if(sum < target){
                i++;
                continue;
            } else{
                j--;
            }
        }

        return new int[0];

        // hashmap solution

        // HashMap<Integer, Integer> numToIndexMap = new HashMap<>();

        // for(int i=0; i< nums.length; i++){
        //     int numCompliment = target - nums[i];
        //     if(numToIndexMap.containsKey(numCompliment)){
        //         return new int[]{numToIndexMap.get(numCompliment), i};
        //     } else{
        //         numToIndexMap.put(nums[i], i);
        //     }
        // }
        // return new int[]{};
    }
    
}
