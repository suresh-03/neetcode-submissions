class KthLargest {

    int k = 0;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;

        pq = new PriorityQueue<Integer>((a, b) -> b - a);

        for(int num : nums){
            pq.add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        int[] temp = new int[k-1];
        int index = 0;
        int kthLargestElement = -1;
        while(index < k-1){
            temp[index++] = pq.poll();
        }
        kthLargestElement = pq.peek();
        for(int i = 0; i < temp.length; i++){
            pq.add(temp[i]);
        }

        return kthLargestElement;


    }
}
