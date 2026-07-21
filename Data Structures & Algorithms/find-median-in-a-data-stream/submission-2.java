class MedianFinder {

    PriorityQueue<Integer> nums;
    public MedianFinder() {
        nums = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        nums.add(num);
    }
    
    public double findMedian() {
        int size = nums.size();
        Queue<Integer> temp = new LinkedList<>();

        if(size % 2 == 0){
            int index = (size / 2) - 1;
            for(int i = 0; i < index; i++){
                temp.offer(nums.poll());
            }
            int n1 = nums.poll();
            int n2 = nums.poll();

            temp.offer(n1);
            temp.offer(n2);

            while(!temp.isEmpty()){
                nums.add(temp.poll());
            }

            return (double)(n1 + n2) / 2;
        }
        int index = size / 2;
        for(int i = 0; i < index; i++){
            temp.offer(nums.poll());
        }
        int n = nums.poll();

        temp.offer(n);

        while(!temp.isEmpty()){
            nums.add(temp.poll());
        }

        return (double)n;
    }
}
