class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(position[i], speed[i]);
            
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a.position, b.position));

        Stack<Pair> stk = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            System.out.println(pairs[i].toString());
            if (stk.isEmpty()) {
                stk.push(pairs[i]);
            } else {
                int pos = pairs[i].position;
                int s = pairs[i].speed;

                double estimatedTimeToReach = ((double)(target - pos)) / (double)s;
                double estimatedTimeToReachStack = ((double)(target - stk.peek().position)) / (double)stk.peek().speed;

                if(estimatedTimeToReachStack < estimatedTimeToReach){
                    stk.push(pairs[i]);
                }
                else{
                }
                
            }
            if(!stk.isEmpty()){
                System.out.println("i="+i+", stk.peek()="+stk.peek().toString());
                }
        }

        return stk.size();
    }
}

class Pair {
    int position;
    int speed;

    public Pair(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }

    public String toString(){
        return "("+this.position+","+this.speed+")";
    }
}
