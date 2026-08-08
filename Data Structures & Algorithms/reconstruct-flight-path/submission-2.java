class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);

            if(graph.containsKey(from)){
                graph.get(from).add(to);
            }
            else{
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(to);
                graph.put(from,pq);
            }
        }

        List<String> itinerary = new ArrayList<>();

        dfs("JFK",graph,itinerary);

        return itinerary;

    }

    private void dfs(String source, Map<String,PriorityQueue<String>> graph, List<String> itinerary){
        PriorityQueue<String> neighbors = graph.get(source);

        while(neighbors != null && !neighbors.isEmpty()){
            String neighbor = neighbors.poll();
            dfs(neighbor,graph,itinerary);
        }

        itinerary.addFirst(source);
    }
}
