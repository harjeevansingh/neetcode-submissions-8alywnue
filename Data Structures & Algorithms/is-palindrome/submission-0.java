class Solution {
    public boolean isPalindrome(String s) {
        int length = s.length();
        int start=0;
        int end = length-1;
        while(start<=end && end > 0){
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                System.out.println("start - " + start + ", end - " + end);
                System.out.println("start - " + s.charAt(start) + ", end - " + s.charAt(end));
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
