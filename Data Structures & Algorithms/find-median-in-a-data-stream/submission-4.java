class MedianFinder {

    PriorityQueue<Integer> largeHeap;
    PriorityQueue<Integer> smallHeap;

    public MedianFinder() {
        largeHeap = new PriorityQueue<>();
        smallHeap = new PriorityQueue<>((a,b) -> b - a);
    }
    
    public void addNum(int num) {
        smallHeap.add(num);

        // if small heap elements greater than large heap, pop that element and add in large heap
        if(!smallHeap.isEmpty() && !largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()){
            largeHeap.add(smallHeap.poll());
        }

        if(smallHeap.size() > largeHeap.size() + 1){
            largeHeap.add(smallHeap.poll());
        }
        if(largeHeap.size() > smallHeap.size() + 1){
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if(smallHeap.size() > largeHeap.size()){
            return (double)smallHeap.peek();
        }
        if(largeHeap.size() > smallHeap.size()){
            return (double)largeHeap.peek();
        }
        return (double)(smallHeap.peek() + largeHeap.peek())/2;
    }
}
