class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null ){
            return 0;
        }

        int length = s.length();

        if(length <= 1){
            return length;
        }

        int maxLength = 1;

        int left = 0;
        int right = 1;

        while(right<length){
            if(s.substring(left, right).contains(String.valueOf(s.charAt(right)))){
                left++;
            } else{
                maxLength = Math.max(maxLength, right-left+1);
                right++;
            }
        }
        return maxLength;
    }
}
