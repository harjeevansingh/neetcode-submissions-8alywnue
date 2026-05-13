class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        if(length == 0 || length == 1){
            return nums;
        } else if(length == 2){
            int[] arr2 = new int[2];
            arr2[0] = nums[1];
            arr2[1] = nums[0];
            return arr2;
        }

        int[] arr = new int[length];

        // Arrays.fill(arr,1);

        int[] preMultipliers = new int[length];
        int[] postMultipliers = new int[length];

        for(int i = 0;i<length;i++){
            int currentMultiplierPre = nums[i];
            int currentMultiplierPost = nums[length - i - 1];
            if(i==0){
                preMultipliers[i] = currentMultiplierPre;
                postMultipliers[length - i - 1] = currentMultiplierPost;
            } else {
                preMultipliers[i] = preMultipliers[i-1] * currentMultiplierPre;
                postMultipliers[length - i - 1] = postMultipliers[length - i] * currentMultiplierPost;
            }
        }

        System.out.println("preMultipliers - " + Arrays.toString(preMultipliers));
        System.out.println("postMultipliers - " + Arrays.toString(postMultipliers));

        int[] result = new int[length];

        for(int j=0;j<length;j++){
            if(j==0){
                result[j] = postMultipliers[1];
            } else if(j== length -1){
                result[j] = preMultipliers[j-1];
            } else{
                result[j] = preMultipliers[j - 1] * postMultipliers[j+1];
            }
        }

        return result;
    }
}  
