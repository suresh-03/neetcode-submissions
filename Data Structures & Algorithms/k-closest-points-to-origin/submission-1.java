class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] kClosestPoints = new int[k][2];

        PriorityQueue<Pair> pq = new PriorityQueue<>(new DistanceComparator());

        for(int i = 0; i < points.length; i++){
            double distance = calculateDistance(points[i]);
            pq.add(new Pair(i, distance));
            if(pq.size() > k){
                pq.poll();
            }
        }

        for(int i = 1; i <= k; i++){
            Pair p = pq.poll();

            kClosestPoints[i-1] = points[p.index];
        }

        return kClosestPoints;


    }

    double calculateDistance(int[] point){
        double n1 = 0 - point[0];
        double n2 = 0 - point[1];

        double sqrSum = (n1 * n1) + (n2 * n2);

        return Math.sqrt(sqrSum);
    }
}

public class DistanceComparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        return Double.compare(p2.distance, p1.distance);
    }
}

class Pair{
    int index;
    double distance;

    public Pair(int index, double distance){
        this.index = index;
        this.distance = distance;
    }
}
