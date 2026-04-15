class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mappedStrs = new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String charStr = new String(chars);
            mappedStrs.computeIfAbsent(charStr, k -> new ArrayList<String>()).add(str);
        }
        return new ArrayList(mappedStrs.values());
    }
}
