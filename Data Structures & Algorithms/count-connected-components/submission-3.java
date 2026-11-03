class Solution {
    public boolean dfs(int i, HashMap<Integer, List<Integer>> edgeMap, boolean[] visited, int prevNode){
        if(visited[i]){
            return false;
        } 

        visited[i] = true;
        if(edgeMap.containsKey(i)){
            for(int neighbour: edgeMap.get(i)){
                if(prevNode != neighbour){
                    dfs(neighbour, edgeMap, visited, i);
                }
            }
        }       

        return true;
    }

    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> edgeMap = new HashMap<>();
        int answer = 0;

        for(int[] edge: edges){
            edgeMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i] && dfs(i, edgeMap, visited, -1)){
                answer++;
            }
        }
        return answer;
    }
}
