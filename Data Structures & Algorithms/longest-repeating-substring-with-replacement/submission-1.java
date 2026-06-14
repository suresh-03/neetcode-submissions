class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int[] frequencyArray = new int[26];
        int l = 0;
        int ans = 0;
        int maxFrequency = 0;
        for(int r = 0; r < n; r++){
            frequencyArray[s.charAt(r)-'A']++;

            maxFrequency = Math.max(maxFrequency,frequencyArray[s.charAt(r)-'A']);

            while((r-l+1) - maxFrequency > k){
                frequencyArray[s.charAt(l++)-'A']--;
            }

            ans = Math.max(ans, r-l+1);
        }

        return ans;
    }


}
