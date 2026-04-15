class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for(int num: nums){
            counts.put(num, counts.computeIfAbsent(num, t -> 0) + 1);
        }
        int[] result = counts.entrySet()
            .stream()
            .sorted((a, b) -> b.getValue() - a.getValue()) // descending by count
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();
        return result;
    }
}
