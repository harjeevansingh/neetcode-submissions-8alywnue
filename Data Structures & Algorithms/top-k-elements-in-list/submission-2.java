class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums){
            freqMap.put(num, freqMap.computeIfAbsent(num, t -> 0) + 1);
        }

        int[] result = freqMap.entrySet()
            .stream()
            .sorted((a,b) -> b.getValue() - a.getValue())
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();

        return result;
    }
}
