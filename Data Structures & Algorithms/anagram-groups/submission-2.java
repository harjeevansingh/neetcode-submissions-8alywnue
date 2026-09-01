class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> strings = new HashMap<>();
        for(String str: strs){
            int[] count = new int[26];
            for(char c: str.toCharArray()){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            strings.computeIfAbsent(key, k->new ArrayList<String>()).add(str);
        }
        return new ArrayList<>(strings.values());
    }
}
