class Solution {
    public int[] twoSum(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1; 
        Map<Integer, Integer> mapping = new HashMap<>();        
        
        // Arrays.sort(nums);

        while(first < last){
            int firstNum = nums[first];
            int lastNum = nums[last];
            int sumOfBoth = firstNum + lastNum;
            if(sumOfBoth ==  target){
                return new int[]{first, last};
            } else {
                int firstCompliment = target - firstNum;
                int lastCompliment = target - lastNum;
                if(mapping.containsKey(firstCompliment)){
                    return new int[]{
                        Math.min(first, mapping.get(firstCompliment)),
                        Math.max(first, mapping.get(firstCompliment)),
                    };
                } else if(mapping.containsKey(lastCompliment)){
                    return new int[]{
                        Math.min(last, mapping.get(lastCompliment)),
                        Math.max(last, mapping.get(lastCompliment)),
                    };
                } 
            }
            mapping.put(firstNum, first);
            mapping.put(lastNum, last);
            first++;
            last--;
        }
        if(first == last){
            int firstNum = nums[first];
            int firstCompliment = target - firstNum;
            if(mapping.containsKey(firstCompliment)){
                return new int[]{
                        Math.min(first, mapping.get(firstCompliment)),
                        Math.max(first, mapping.get(firstCompliment)),
                    };
            }
        }
        return new int[]{};
    }
}
