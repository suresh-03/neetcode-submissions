class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int source = prerequisites[i][0];
            int neighbor = prerequisites[i][1];

            if (graph.containsKey(source)) {
                graph.get(source).add(neighbor);
            } else {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(neighbor);
                graph.put(source, neighbors);
            }
        }
        boolean[] completed = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];

            if (!dfs(i, graph, visited,completed)) {
                return false;
            }
            completed[i] = true;
        }
        return true;
    }

    public boolean dfs(int source, Map<Integer, List<Integer>> graph, boolean[] visited,boolean[] completed) {
        if(completed[source]){
            return true;
        }
        if (visited[source]) {
            return false;
        }

        visited[source] = true;

        List<Integer> neighbors = graph.get(source);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (!dfs(neighbor, graph, visited,completed)) {
                    return false;
                }
                else{
                    completed[neighbor] = true;
                }
            }
        }
        return true;
    }
}
