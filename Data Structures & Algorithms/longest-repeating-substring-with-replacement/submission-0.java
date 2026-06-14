class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int[] frequencyArray = new int[26];
        int l = 0;
        int ans = 0;

        for(int r = 0; r < n; r++){
            frequencyArray[s.charAt(r)-'A']++;

            while(Math.abs(findMax(frequencyArray)-(r-l+1)) > k){
                frequencyArray[s.charAt(l++)-'A']--;
            }

            ans = Math.max(ans, r-l+1);
        }

        return ans;
    }

    public int findMax(int[] arr){
        int max = 0;
        for(int num : arr){
            max = Math.max(max, num);
        }
        return max;
    }
}
