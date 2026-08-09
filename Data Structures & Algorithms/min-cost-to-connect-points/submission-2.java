class Solution {
    public int minCostConnectPoints(int[][] points) {
        int minCost = 0;
        int n = points.length;

        Set<Integer> visitedSet = new HashSet<>();
        Map<Integer, List<Pair>> graph = new HashMap<>();

        buildGraph(points, graph);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.add(new Pair(0, 0));

        while (visitedSet.size() < n) {
            Pair p = pq.poll();
            int edge = p.edge;
            int weight = p.weight;

            if (visitedSet.contains(edge)) {
                continue;
            }

            visitedSet.add(edge);
            minCost += weight;
            List<Pair> list = graph.get(edge);

            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (!visitedSet.contains(list.get(i).edge)) {
                        pq.add(list.get(i));
                    }
                }
            }
        }

        return minCost;
    }

    private void buildGraph(int[][] points, Map<Integer, List<Pair>> graph) {
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance = calculateDistance(points[i], points[j]);

                if (graph.containsKey(i)) {
                    graph.get(i).add(new Pair(j, distance));
                } else {
                    List<Pair> list = new ArrayList<>();
                    list.add(new Pair(j, distance));
                    graph.put(i, list);
                }
                if (graph.containsKey(j)) {
                    graph.get(j).add(new Pair(i, distance));
                } else {
                    List<Pair> list = new ArrayList<>();
                    list.add(new Pair(i, distance));
                    graph.put(j, list);
                }
            }
        }
    }

    private int calculateDistance(int[] p1, int[] p2) {
        int x1 = p1[0];
        int y1 = p1[1];
        int x2 = p2[0];
        int y2 = p2[1];

        return (int) Math.abs(x1 - x2) + (int) Math.abs(y1 - y2);
    }

    private class Pair {
        int edge;
        int weight;

        public Pair(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }

        public String toString() {
            return String.format("(%s,%s)", edge, weight);
        }
    }
}
