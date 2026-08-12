class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<Pair>> graph = new HashMap<>();

        for(int i = 0; i < flights.length; i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];

            if(graph.containsKey(from)){
                graph.get(from).add(new Pair(to,price));
            }
            else{
                List<Pair> list = new ArrayList<>();
                list.add(new Pair(to,price));
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

            int to = flight.to;
            int price = flight.price;
            int stops = flight.stops;

            if(stops > k ){
                continue;
            }
            List<Pair> fs = graph.get(flight.to);

            if(fs != null){
                for(Pair p : fs){
                    if(price + p.price < prices[p.to] && stops <= k){
                        prices[p.to] = price + p.price;
                        
                        q.offer(new Flight(p.to,price + p.price,stops + 1));
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

    private class Pair{
        int to;
        int price;
        
        public Pair(int to, int price){
            this.to = to;
            this.price = price;
        }
    }
}
