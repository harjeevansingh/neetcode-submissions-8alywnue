class Solution {
    boolean valid(Map<Character,Integer> window,
        Map<Character,Integer> target) {

        for(char c : target.keySet()) {
            if(window.getOrDefault(c,0)
                    < target.get(c))
                return false;
    }

    return true;
}
    public String minWindow(String s, String t) {
        int length = s.length();

        String result = "";
        int minLength = Integer.MAX_VALUE;

        int left = 0, right = 0;

        Map<Character, Integer> targetCounter = new HashMap<>();

        for(char c: t.toCharArray()){
            targetCounter.put(c, targetCounter.computeIfAbsent(c, k -> 0) + 1);
        }


        Map<Character, Integer> currentCounter = new HashMap<>();
        while(left<=right && right<length){
            // console.log("")
            char rightChar = s.charAt(right);
            if(targetCounter.containsKey(rightChar)){
                currentCounter.put(rightChar, currentCounter.computeIfAbsent(rightChar, k -> 0) + 1);
            }
            System.out.println("result 1 - "+result);
            System.out.println("minLength 1 - "+minLength);
            System.out.println("(right - left +1) 1 - "+(right - left +1));
            while(valid(currentCounter,targetCounter)){
                // System.out.println("result 2 - "+result);
                    if(right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        result = s.substring(left, right + 1);
                    }
                // System.out.println("minLength 2 - "+minLength);
                // System.out.println("(right - left +1) 2 - "+(right - left +1));
                if(targetCounter.containsKey(s.charAt(left)))
                    currentCounter.put(s.charAt(left), Math.max(0, currentCounter.computeIfAbsent( s.charAt(left), k -> 0) - 1));
                left++;
            }
            right++;
        }

        return result;
        
    }
}
