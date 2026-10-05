class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < hand.length; i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> set : map.entrySet()){
            int key = set.getKey();
            pq.add(key);
        }

        while(!pq.isEmpty()){
            int first = pq.peek();

            for(int num = first; num < first + groupSize; num++){
                if(!map.containsKey(num)){
                    return false;
                }
                map.put(num,map.get(num)-1);

                if(map.get(num) == 0){
                    if(num != pq.peek()){
                        return false;
                    }
                    pq.poll();
                }
            }

        }
        return true;
    }
}
