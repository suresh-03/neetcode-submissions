class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int i = 0;

        int[] ans = new int[n-k+1];

        for(int r = 0; r < n; r++){
            if(!deque.isEmpty() && deque.getLast() <= r-k){
                deque.pollLast();
            }

            while(!deque.isEmpty() && nums[deque.getFirst()] <= nums[r]){
                deque.pollFirst();
            }

            deque.push(r);
            if(r >= k-1){
                ans[i++] = nums[deque.getLast()];
            }
        }

        return ans;
    }
}
