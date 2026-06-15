class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if(s1Len > s2Len){
            return false;
        }

        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];

        for(int i = 0; i < s1Len; i++){
            freqS1[s1.charAt(i)-'a']++;
        }

        int l = 0;

        for(int r = 0; r < s2Len; r++){
            char ch = s2.charAt(r);
            freqS2[ch-'a']++;
          
            if((r-l+1) > s1Len){
                freqS2[s2.charAt(l++)-'a']--;
            }
            if(Arrays.equals(freqS1,freqS2)){
                return true;
            }
        }

        return false;


    }
}
