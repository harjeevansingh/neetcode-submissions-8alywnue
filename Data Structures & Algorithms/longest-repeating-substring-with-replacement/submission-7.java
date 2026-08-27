class Solution {
    public int characterReplacement(String s, int k) {
        int mostFrequency = 0;
        int maxLength = 0;

        int left = 0;

        HashMap<Character, Integer> counter = new HashMap<>();
        for(int right=0;right<s.length();right++){
            counter.put(s.charAt(right), counter.getOrDefault(s.charAt(right), 0) + 1);
            mostFrequency = Math.max(counter.get(s.charAt(right)), mostFrequency);
            if(right-left+1-mostFrequency<=k){
                maxLength = Math.max(maxLength, right-left+1);
            } else{
                counter.put(s.charAt(left), counter.get(s.charAt(left)) - 1);
                if(!counter.values().contains(mostFrequency)){
                    mostFrequency--;
                }
                left++;
            }
        }
        return maxLength;
    }
}
