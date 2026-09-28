class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> numSet = new HashSet<>();

        for(int num: nums){
            numSet.add(num);
        }

        int maxLength = 0;

        for(int num: numSet){
            if(numSet.contains(num-1)){
                continue;
            }
            int check = num+1;
            int currentLength = 1;
            while(numSet.contains(check)){
                currentLength++;
                check++;
            }
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
