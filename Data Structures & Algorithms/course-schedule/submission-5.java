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

        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, state)) {
                return false;
            }
            state[i] = 2;
        }
        return true;
    }

    public boolean dfs(int source, Map<Integer, List<Integer>> graph, int[] state) {
        if(state[source] == 2){
            return true;
        }
        if (state[source] == 1) {
            return false;
        }

        state[source] = 1;

        List<Integer> neighbors = graph.get(source);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (!dfs(neighbor, graph, state)) {
                    return false;
                }
                else{
                    state[neighbor] = 2;
                }
            }
        }
        return true;
    }
}