class Solution {
    public int countComponents(int n, int[][] edges) {
        int m = edges.length;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            int v = edges[i][0];
            int u = edges[i][1];

            if (graph.containsKey(v)) {
                graph.get(v).add(u);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(u);
                graph.put(v, list);
            }
            if (graph.containsKey(u)) {
                graph.get(u).add(v);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(v);
                graph.put(u, list);
            }
        }
        int count = 0;
        for(int source = 0; source < n; source++){
            if(!visited[source]){
                count++;
                dfs(source,graph,visited);
            }
        }
        return count;
    }

    public void dfs(int source, Map<Integer,List<Integer>> graph, boolean[] visited){
        if(visited[source]){
            return;
        }

        visited[source] = true;

        List<Integer> neighbors = graph.get(source);

        if(neighbors != null){
            for(int neighbor : neighbors){
                dfs(neighbor,graph,visited);
            }
        }
    }
}
