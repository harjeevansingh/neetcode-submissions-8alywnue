class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] suffix = new int[length];

        int suffixCurrent = 1;
        for(int i=0; i< length; i++){
            suffix[length - 1 - i] = suffixCurrent;
            suffixCurrent *= nums[length - 1 - i];  
        }

        // System.out.print("suffix - ");
        // for(int suffixEach: suffix){
        //     System.out.print(suffixEach + ", ");
        // }
        // System.out.println();

        int[] result = new int[length];
        int prefixCurrent = 1;
        for(int j=0; j<length; j++){
            result[j] = suffix[j] * prefixCurrent;
            prefixCurrent *= nums[j];
        }

        return result;
        
    }
}  
