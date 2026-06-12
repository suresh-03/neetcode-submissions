class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxArea = 0;

        int[] prefixMaxArr = new int[n];
        int[] suffixMaxArr = new int[n];

        int prefixMax = 0;

        for(int i = 0; i < n; i++){
            prefixMaxArr[i] = prefixMax;
            prefixMax = Math.max(prefixMax,height[i]);
        }

        int suffixMax = 0;

        for(int i = n-1; i >= 0; i--){
            suffixMaxArr[i] = suffixMax;
            suffixMax = Math.max(suffixMax,height[i]);
        }

        for(int i = 0; i < n; i++){
            int area = Math.min(prefixMaxArr[i],suffixMaxArr[i])-height[i];
            if(area > 0){
                maxArea += area;
            }
        }

        return maxArea;
    }
}
