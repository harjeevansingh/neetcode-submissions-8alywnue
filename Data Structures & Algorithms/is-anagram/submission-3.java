class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> track1 = new HashMap<>();
        HashMap<Character, Integer> track2 = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            track1.put(s.charAt(i), track1.getOrDefault(s.charAt(i), 0) + 1);
            track2.put(t.charAt(i), track2.getOrDefault(t.charAt(i), 0) + 1);
        }

        return track1.equals(track2);
    }
}
