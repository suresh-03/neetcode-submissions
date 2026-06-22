class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] leftBoundary = new int[n];
        int[] rightBoundary = new int[n];

        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]){
                stk.pop();
            }
            leftBoundary[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }

        stk = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]){
                stk.pop();
            }
            rightBoundary[i] = stk.isEmpty() ? n : stk.peek();
            stk.push(i);
        }

        System.out.println(Arrays.toString(leftBoundary));
        System.out.println(Arrays.toString(rightBoundary));

        int ans = 0;

        for(int i = 0; i < n; i++){ 
            int area = heights[i] * ((rightBoundary[i] - leftBoundary[i])-1);
            ans = Math.max(ans, area);
        }

        return ans;
    }
}
