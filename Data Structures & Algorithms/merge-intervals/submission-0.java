class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        resultList.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int[] lastResultElement = resultList.get(resultList.size() -1);

            if(intervals[i][0]<=lastResultElement[1]){
                lastResultElement[1] = Math.max(lastResultElement[1], intervals[i][1]);
            } else {
                resultList.add(intervals[i]);
            }
        }
        return resultList.toArray(new int[0][]);
    }
}
