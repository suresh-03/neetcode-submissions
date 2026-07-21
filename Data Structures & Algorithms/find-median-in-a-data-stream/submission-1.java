class MedianFinder {

    List<Integer> nums;
    public MedianFinder() {
        nums = new ArrayList<>();
    }
    
    public void addNum(int num) {
        nums.add(num);
        Collections.sort(nums);
    }
    
    public double findMedian() {
        int size = nums.size();

        if(size % 2 == 0){
            double n1 = nums.get(size/2-1);
            double n2 = nums.get(size/2);

            return (double)(n1+n2)/2;
        }
        return (double)nums.get(size/2);
    }
}
