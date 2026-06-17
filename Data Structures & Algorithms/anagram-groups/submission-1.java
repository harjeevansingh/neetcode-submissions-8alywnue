class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anaGroups = new HashMap<>();

        for(String str: strs){
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String orderedStr = new String(strChars);
            anaGroups.computeIfAbsent(orderedStr, k -> new ArrayList<String>()).add(str);
        }

        return new ArrayList(anaGroups.values());
    }
}
