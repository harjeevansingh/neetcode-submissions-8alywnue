class Solution {

    // Optimised Solution - 

    public int characterReplacement(String s, int k) {
        int length = s.length();

        int left = 0;
        int right = 0;

        int result = 0;

        int maxLength = 0;

        Map<Character, Integer> counter = new HashMap<>();

        while(left<=right && right<length){
            char currentRightChar = s.charAt(right);
            counter.put(currentRightChar, counter.computeIfAbsent(currentRightChar, j -> 0) + 1);
            maxLength = Math.max(maxLength, counter.get(currentRightChar));

            while((right - left + 1) - maxLength > k){
                char currentLeftChar = s.charAt(left);
                counter.put(currentLeftChar, counter.get(currentLeftChar) - 1);
                left++;
            }


            result = Math.max(result, right - left + 1);

            right++;

        }

        return result;
    }




    // Less optimised Solution - 

    // public int characterReplacement(String s, int k) {
    //     int length = s.length();

    //     int left = 0;
    //     int right = 0;

    //     int result = 0;

    //     Map<Character, Integer> counter = new HashMap<>();

    //     while(left<=right && right<length){
    //         char currentRightChar = s.charAt(right);
    //         counter.put(currentRightChar, counter.computeIfAbsent(currentRightChar, j -> 0) + 1);

    //         while((right - left + 1) - Collections.max(counter.values()) > k){
    //             char currentLeftChar = s.charAt(left);
    //             counter.put(currentLeftChar, counter.get(currentLeftChar) - 1);
    //             left++;
    //         }

    //         result = Math.max(result, right - left + 1);

    //         right++;

    //     }

    //     return result;
    // }
}
