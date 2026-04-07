class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> setNums = new HashSet<>();

        for(int i: nums){
            if(setNums.contains(i)){
                return true;
            } else {
                setNums.add(i);
            }
        }
        return false;
    }
}