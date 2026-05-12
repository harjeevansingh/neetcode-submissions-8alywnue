class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] arr = new int[length];

        Arrays.fill(arr,1);

        // Map<Integer> multipliers = new HashMap<Integer>;

        for(int i = 0;i<length;i++){
            int currentMultiplier = nums[i];
            for(int j = 0;j<length;j++){
                if(i!=j){
                    arr[j] *= currentMultiplier;
                }
            }
        }

        return arr;
    }
}  
