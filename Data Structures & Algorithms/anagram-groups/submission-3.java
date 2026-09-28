class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();


        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            result.computeIfAbsent(sortedStr, k -> new LinkedList()).add(str);
        }

        return new ArrayList(result.values());
    }
}
