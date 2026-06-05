class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        
        for (int num : nums) {
            numsSet.add(num);
        }

        int maxLength = 0;

        for(Integer num: numsSet){
            int currentLength = 1;
            int currentNum = num;
            if(!numsSet.contains(currentNum -1)){
                while(numsSet.contains(currentNum + 1)){
                    currentLength++;
                    currentNum++;
                }
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
