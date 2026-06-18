class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] prefixes = new int[length];
        int[] postfixes = new int[length];
        
        int leftStart = 1;
        for(int i=0;i<length;i++){
            prefixes[i] = leftStart;
            leftStart *= nums[i];
        }

        int rightStart = 1;
        for(int j=0;j<length;j++){
            postfixes[length -1 - j] = rightStart;
            rightStart *= nums[length -1 - j];
        }

        int[] result = new int[length];
        for(int k=0;k<length;k++){
            int currentResult = prefixes[k] * postfixes[k];
            result[k] = currentResult;
        }
        System.out.println("prefixes - " + Arrays.toString(prefixes));
        System.out.println("postfixes - " + Arrays.toString(postfixes));
        System.out.println("result - " + Arrays.toString(result));
        return result;
    }
}  
