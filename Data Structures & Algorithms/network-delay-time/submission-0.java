class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<Pair>> graph = new HashMap<>();
        int[] distance = new int[n+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.t - b.t);

        for(int i = 0; i <= n; i++){
            if(i != k){
                distance[i] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int t = times[i][2];

            Pair p = new Pair(v,t);

            if(graph.containsKey(u)){
                graph.get(u).add(p);
            }
            else{
                List<Pair> list = new ArrayList<>();
                list.add(p);
                graph.put(u,list);
            }
        }

        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int v = p.v;
            int t = p.t;

            List<Pair> neighbors = graph.get(v);

            if(neighbors != null){
                for(Pair neighbor : neighbors){
                    if(t + neighbor.t < distance[neighbor.v]){
                        distance[neighbor.v] = t + neighbor.t;
                        pq.add(new Pair(neighbor.v,distance[neighbor.v]));
                    }
                }
            }

        }

        int max = 0;

        for(int i = 1; i <= n; i++){
            max = Math.max(max,distance[i]);
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }

    private class Pair{
        int v;
        int t;

        public Pair(int v, int t){
            this.v = v;
            this.t = t;
        }
    }
}
