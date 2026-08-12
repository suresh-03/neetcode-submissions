class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<Flight>> graph = new HashMap<>();

        for(int i = 0; i < flights.length; i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];

            if(graph.containsKey(from)){
                graph.get(from).add(new Flight(to,price,0));
            }
            else{
                List<Flight> list = new ArrayList<>();
                list.add(new Flight(to,price,0));
                graph.put(from,list);
            }
        }

        Queue<Flight> q = new LinkedList<>();
        int[] prices = new int[n];

        for(int i = 0; i < n; i++){
            prices[i] = Integer.MAX_VALUE;
        }

        prices[src] = 0;
        q.offer(new Flight(src,0,0));

        while(!q.isEmpty()){
            Flight flight = q.poll();

            if(flight.stops > k ){
                continue;
            }
            List<Flight> fs = graph.get(flight.to);

            if(fs != null){
                for(Flight f : fs){
                    if(flight.price + f.price < prices[f.to] && flight.stops <= k){
                        prices[f.to] = flight.price + f.price;
                        
                        q.offer(new Flight(f.to,flight.price + f.price,flight.stops + 1));
                    }
                }
            }
        }

        if(prices[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return prices[dst];
    }

    private class Flight{
        int to;
        int price;
        int stops;

        public Flight(int to, int price, int stops){
            this.to = to;
            this.price = price;
            this.stops = stops;
        }
    }
}
