class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> numsSet = new HashSet<>();
        int longest = 0;

        for(int num: nums){
            numsSet.add(num);
        }

        for(int i=0; i<nums.length; i++){
            if(!numsSet.contains(nums[i]-1)){
                int currentLongest = 1;
                int biggerNumber = nums[i]+1;
                // System.out.println(biggerNumber);
                while(numsSet.contains(biggerNumber)){
                    // System.out.println(biggerNumber);
                    currentLongest++;
                    biggerNumber++;
                }
                longest = Math.max(longest, currentLongest);
            }
        }

        return longest;
    }
}
