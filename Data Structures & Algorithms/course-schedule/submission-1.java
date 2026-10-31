class Solution {

    public boolean dfs(int currentCourse, 
        HashMap<Integer, List<Integer>> preMap,       
        boolean[] visited
    ){
        if(
            visited[currentCourse]
        ){
            return false;
        }

        List<Integer> preReqs = preMap.get(currentCourse);
        
        if(preReqs == null || preReqs.size() == 0){
            return true;
        }

        visited[currentCourse] = true;

        for(int preReq: preReqs){
            if(!dfs(preReq, preMap, visited)){
                return false;
            }
        }

        visited[currentCourse] = false;

        preMap.put(currentCourse, new LinkedList<>());

        return true;
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        // HashSet<Integer> visited = new HashSet<>();
        boolean[] visited = new boolean[numCourses];

        for(int[] pre: prerequisites){
            preMap.computeIfAbsent(pre[0], k -> new LinkedList<Integer>()).add(pre[1]);
        }

        for(int i=0;i<numCourses;i++){
            if(!preMap.containsKey(i)){
                continue;
            }

            if(!dfs(i, preMap, visited)){
                return false;
            }
        }

        return true;
    }
}
