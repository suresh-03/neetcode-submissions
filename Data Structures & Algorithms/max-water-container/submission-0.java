class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;

        int s = 0;
        int e = heights.length-1;

        while(s < e){
            int minHeight = Math.min(heights[s],heights[e]);

            maxWater = Math.max(maxWater,minHeight * (e-s));

            if(heights[s] > heights[e]){
                e--;
            }
            else{
                s++;
            }
        }

        return maxWater;
    }
}
