class Solution {
    public int[] findOrder(int numCourses, int[][] pr) {
        int n = pr.length;

        int[] ans = new int[numCourses];
        Map<Integer,List<Integer>> graph = new HashMap<>();

        for(int r = 0; r < n; r++){
            int v = pr[r][0];
            int u = pr[r][1];

            if(graph.containsKey(v)){
                graph.get(v).add(u);
            }
            else{
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(u);
                graph.put(v,neighbors);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        int[] state = new int[numCourses];

        for(int c = 0; c < numCourses; c++){
            if(!dfs(c,state,q,graph)){
                return new int[]{};
            }
        }

        int index = 0;
        while(!q.isEmpty()){
            ans[index++] = q.poll();
        }

        return ans;
    }

    public boolean dfs(int source, int[] state, Queue<Integer> q, Map<Integer,List<Integer>> graph){
        if(state[source] == 2){
            return true;
        }
        if(state[source] == 1){
            return false;
        }

        state[source] = 1;

        List<Integer> neighbors = graph.get(source);

        if(neighbors != null){
            for(int neighbor : neighbors){
                if(!dfs(neighbor,state,q,graph)){
                    return false;
                }
                else{
                    state[neighbor] = 2;
                }
            }
        }
        state[source] = 2;
        q.offer(source);
        return true;
    }
}
