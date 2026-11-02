class Solution {

    public boolean dfs(int i, HashMap<Integer, HashSet<Integer>> edgeMap, int previousNode, boolean[] visited){
        if(visited[i]){
            return false;
        }


        visited[i] = true;


        if(!edgeMap.containsKey(i)){
            return true;
        }

        for(int neighbour: edgeMap.get(i)){
            if(neighbour != previousNode){
                if(!dfs(neighbour, edgeMap, i, visited)){
                    return false;
                }
            }
        }
        return true;

    }

    public boolean validTree(int n, int[][] edges) {
        if(n == 0){
            return true;
        }

        HashMap<Integer, HashSet<Integer>> edgeMap = new HashMap<>();

        for(int[] edge: edges){
            edgeMap.computeIfAbsent(edge[0], k -> new HashSet<Integer>()).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], k -> new HashSet<Integer>()).add(edge[0]);
        }

        // HashSet<Integer> visited = new HashSet<>();
        boolean[] visited = new boolean[n];

        if (!dfs(0, edgeMap, -1, visited)) {
            return false;
        }

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;

    }
}
