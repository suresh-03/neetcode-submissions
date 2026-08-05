class Solution {
    public boolean validTree(int n, int[][] edges) {
        int m = edges.length;

        boolean[] visited = new boolean[n];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int v = edges[i][0];
            int u = edges[i][1];

            if (graph.containsKey(v)) {
                graph.get(v).add(u);
            } else {
                List<Integer> neighbor = new ArrayList<>();
                neighbor.add(u);
                graph.put(v, neighbor);
            }
            if (graph.containsKey(u)) {
                graph.get(u).add(v);
            } else {
                List<Integer> neighbor = new ArrayList<>();
                neighbor.add(v);
                graph.put(u, neighbor);
            }
        }

        if(!dfs(0, graph, visited, -1)){
            return false;
        }

        for (boolean isVisited : visited) {
            if (!isVisited) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int source, Map<Integer, List<Integer>> graph, boolean[] visited, int parent) {
        if (visited[source]) {
            return true;
        }

        visited[source] = true;

        List<Integer> neighbors = graph.get(source);

        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (neighbor != parent && visited[neighbor]) {
                    return false;
                }
                if (!visited[neighbor]) {
                    dfs(neighbor, graph, visited, source);
                }
            }
        }
        return true;
    }
}
