class Solution {

    public boolean dfs(int i, HashMap<Integer, List<Integer>> edgeMap, int previousNode, HashSet<Integer> visited){
        if(visited.contains(i)){
            return false;
        }


        visited.add(i);


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

        HashMap<Integer, List<Integer>> edgeMap = new HashMap<>();

        for(int[] edge: edges){
            edgeMap.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        return dfs(0, edgeMap, -1, visited) && visited.size() == n; 

    }
}
